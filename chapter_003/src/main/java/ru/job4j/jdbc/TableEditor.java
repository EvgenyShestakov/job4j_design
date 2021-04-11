package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        ClassLoader loader = TableEditor.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            properties.load(io);
            Class.forName(properties.getProperty("driver_registration"));
            String url = properties.getProperty("url");
            String login = properties.getProperty("login");
            String password = properties.getProperty("password");
            connection =  DriverManager.getConnection(url, login, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String sql = String.format(
                "create table if not exists %s();", tableName);
        executionRequest(sql);
    }

    public void dropTable(String tableName) {
        String sql = String.format(
                "drop table if exists %s;", tableName);
        executionRequest(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format(
                "alter table %s add %s %s;", tableName, columnName, type);
        executionRequest(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format(
                "alter table %s drop %s;", tableName, columnName);
        executionRequest(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format(
                "alter table %s rename %s to %s;", tableName, columnName, newColumnName);
        executionRequest(sql);
    }

    public String getScheme(String tableName) {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = null;
        try {
            metaData = connection.getMetaData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try (ResultSet columns = Objects.requireNonNull(metaData).
                getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return scheme.toString();
    }

    private void executionRequest(String sql)  {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close()  {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
