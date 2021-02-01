package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            String line;
            boolean flag = true;
            String start = null;
            String finish = null;
            StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
            while ((line = in.readLine()) != null) {
                if ((line.startsWith("400") || line.startsWith("500")) && flag) {
                    flag = false;
                    start = line.substring(4) + ";";
                } else if ((line.startsWith("200") || line.startsWith("300")) && !flag) {
                    flag = true;
                    finish = start + line.substring(4) + ";";
                }
                if (finish != null) {
                    stringJoiner.add(finish);
                    finish = null;
                }
            }
            out.write(stringJoiner.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> download(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void write(String file) {
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("C:/projects/job4j_design/chapter_002/src/"
                + "main/java/ru/job4j/io/resources/source.txt", "C:/projects/job4j_design/chapter_002/src/"
                + "main/java/ru/job4j/io/resources/target.txt");
    }
}
