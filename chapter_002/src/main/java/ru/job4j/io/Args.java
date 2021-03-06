package ru.job4j.io;

public class Args {
    private final String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        boolean flag = true;
        if (args.length != 4) {
            System.out.println("Not enough arguments");
            flag = false;
        } else {
            if (!args[0].startsWith("-d")) {
                System.out.println("Directory not found");
                flag = false;
            }
            if (!args[1].startsWith("-n")) {
                System.out.println("Name not found");
                flag = false;
            }
            if (!args[2].startsWith("-t")) {
                System.out.println("Search type not found");
                flag = false;
            }
            if (!args[3].startsWith("-o")) {
                System.out.println("Output not found");
                flag = false;
            }
        }
        return flag;
    }

    public String directory() {
        String[] array = args[0].split("=");
        return array[1];
    }

    public String name() {
        String[] array = args[1].split("=");
        return array[1];
    }

    public String searchType() {
        String[] array = args[2].split("=");
        return array[1];
    }

    public String output() {
        String[] array = args[3].split("=");
        return array[1];
    }
}
