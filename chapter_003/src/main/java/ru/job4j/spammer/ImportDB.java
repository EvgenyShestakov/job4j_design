package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties cfg = new Properties();
    private String dump;
    private Connection connection;

    public ImportDB(String dump) {
        this.dump = dump;
        initConnection();
    }

    private void initConnection() {
        ClassLoader loader = ImportDB.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            cfg.load(io);
            Class.forName(cfg.getProperty("jdbc.driver"));
            String url = cfg.getProperty("jdbc.url");
            String login = cfg.getProperty("jdbc.username");
            String password = cfg.getProperty("jdbc.password");
            connection =  DriverManager.getConnection(url, login, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(s -> {
                String[] user = s.split(";");
                users.add(new User(user[0], user[1]));
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        for (User user : users) {
            try (PreparedStatement ps = connection.
                    prepareStatement("insert into users(name, email) values (?, ?)")) {
                ps.setString(1, user.name);
                ps.setString(2, user.email);
                ps.execute();
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        ImportDB db = new ImportDB("./dump.txt");
        db.save(db.load());
    }
}
