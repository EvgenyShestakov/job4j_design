package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConsoleChat {
    private final String log;
    private final String botAnswers;
    private final List<String> answers = new ArrayList<>();
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String log, String botAnswers) {
        this.log = log;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(log, StandardCharsets.UTF_8));
             BufferedReader user = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            String text = null;
            String textBot;
            boolean key = true;
            while (!Objects.equals(text, OUT)) {
                text = user.readLine();
                out.write("Я - " + text + System.lineSeparator());
                if (Objects.equals(text, CONTINUE)) {
                    key = true;
                    continue;
                } else if (Objects.equals(text, STOP) || Objects.equals(text, OUT)) {
                    key = false;
                }
                if (key) {
                    textBot = bot();
                    System.out.println(textBot);
                    out.write("Бот - " + textBot + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String bot() {
        if (answers.isEmpty()) {
            try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
                while (in.ready()) {
                    answers.add(in.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int index = (int) (Math.random() * answers.size());
        return  answers.get(index);
    }

    public static void main(String[]args) {
        ConsoleChat cc = new ConsoleChat("C:/projects/job4j_design/chapter_002/src/main/java/ru/"
                + "job4j/io/resources/ConsoleChatLog.txt",
                "C:/projects/job4j_design/chapter_002/src"
                        + "/main/java/ru/job4j/io/resources/ConsoleChatAnswers.txt");
        cc.run();
    }
}

