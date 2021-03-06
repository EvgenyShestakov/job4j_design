package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().filter(s -> s.lastIndexOf("404") != -1).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            log.forEach(s -> out.write(s + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("C:/projects/job4j_design/chapter_002/src/main/"
                + "java/ru/job4j/io/resources/log.txt");
        save(log, "C:/projects/job4j_design/chapter_002/src/main//java/ru/job4j/"
                + "io/resources/result.txt");
        log.forEach(System.out::println);
    }
}
