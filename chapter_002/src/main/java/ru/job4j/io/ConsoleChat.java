package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ConsoleChat {
    private final String log;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String log, String botAnswers) {
        this.log = log;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> logList = new ArrayList<>();
        try (BufferedReader user = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            List<String> answers = new ArrayList<>();
            Stream<String> lines = Files.lines(Paths.get(botAnswers));
            lines.forEach(answers::add);
            String text = null;
            String textBot;
            boolean key = true;
            while (!Objects.equals(text, OUT)) {
                text = user.readLine();
                logList.add("Я - " + text);
                if (Objects.equals(text, CONTINUE)) {
                    key = true;
                    continue;
                } else if (Objects.equals(text, STOP) || Objects.equals(text, OUT)) {
                    key = false;
                }
                if (key) {
                    int index = (int) (Math.random() * answers.size());
                    textBot = answers.get(index);
                    System.out.println(textBot);
                    logList.add("Бот - " + textBot);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(log, StandardCharsets.UTF_8))) {
            logList.forEach(s -> {
                try {
                    out.write(s + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args) {
        ConsoleChat cc = new ConsoleChat("C:/projects/job4j_design/chapter_002/src/main/java/ru/"
                + "job4j/io/resources/ConsoleChatLog.txt",
                "C:/projects/job4j_design/chapter_002/src"
                        + "/main/java/ru/job4j/io/resources/ConsoleChatAnswers.txt");
        cc.run();
    }
}

