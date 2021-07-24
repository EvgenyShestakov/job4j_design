package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
