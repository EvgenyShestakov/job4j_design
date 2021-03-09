package ru.job4j.io.filesearch;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private final String[] args;
    private  Map<String, String> pair = new HashMap<>();
    private SearchFiles searcher;

    public Args(String[] args) {
        this.args = args; }

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
        if (flag) {
            String name = pair.get("-n");
            switch (pair.get("-t")) {
                case ("name") :
                    searcher = new SearchFiles(p -> p.getFileName().toString().equals(name));
                    break;
                case ("mask") :
                    searcher = new SearchFiles(p -> p.getFileName().toString().endsWith(name.substring(1)));
                    break;
                case ("regex") :
                    searcher = new SearchFiles(p -> p.getFileName().toString().matches(name));
                    break;
                default :
                    System.out.println("The search type is set incorrectly");
                    flag = false;
            }
        }
        return flag;
    }

    public Map<String, String> getPair() {
        return pair;
    }

    public SearchFiles getSearcher() {
        return searcher;
    }
}
