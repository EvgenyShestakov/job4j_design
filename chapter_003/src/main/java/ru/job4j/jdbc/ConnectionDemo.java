package ru.job4j.jdbc;

import ru.job4j.service.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            settings.load(io);
        }
        String url = settings.getValue("url");
        String login = settings.getValue("login");
        String password = settings.getValue("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}