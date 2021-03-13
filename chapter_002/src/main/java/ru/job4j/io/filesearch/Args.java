package ru.job4j.io.filesearch;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private final String[] args;
    private final Map<String, String> pair = new HashMap<>();

    public Args(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        boolean flag = true;
        if (args.length != 4) {
            System.out.println("Not enough arguments");
            flag = false;
        } else {
            for (String arg : args) {
                String[] strings = arg.split("=");
                if (strings.length == 2) {
                    pair.put(strings[0], strings[1]);
                } else {
                    System.out.println("Arguments set incorrectly");
                    flag = false;
                }
            }
            if (flag) {
                if (!pair.containsKey("-d")) {
                    System.out.println("Directory not found");
                    flag = false;
                }
                if (!pair.containsKey("-n")) {
                    System.out.println("Name not found");
                    flag = false;
                }
                if (!pair.containsKey("-t")) {
                    System.out.println("Search type not found");
                    flag = false;
                }
                if (!pair.containsKey("-o")) {
                    System.out.println("Output not found");
                    flag = false;
                }
            }
        }
        return flag;
    }

    public Map<String, String> getPair() {
        return pair;
    }
}
