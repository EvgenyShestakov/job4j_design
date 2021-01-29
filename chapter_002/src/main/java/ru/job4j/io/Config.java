package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            in.lines().filter(s -> !((s.startsWith("#")) || s.isEmpty())).map(s -> s.
                    split("=")).forEach((strings -> {
                if (strings.length != 2) {
                    throw new IllegalArgumentException();
                }
                values.put(strings[0], strings[1]);
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("C:/projects/job4j_design/chapter_002/src/main/"
                + "java/ru/job4j/io/resources/app.properties.txt");
        config.load();
        System.out.println(config.value("hibernate.connection.url"));
    }
}
