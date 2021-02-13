package ru.job4j.io;

public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        boolean flag = true;
        if (args.length != 3) {
            System.out.println("Not enough arguments");
            flag = false;
        } else {
            if (!args[0].startsWith("-d")) {
                System.out.println("Directory not found");
                flag = false;
            }
            if (!args[1].startsWith("-e")) {
                System.out.println("Exclude not found");
                flag = false;
            }
            if (!args[2].startsWith("-o")) {
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

    public String exclude() {
        String[] array = args[1].split("=");
        return array[1];
    }

    public String output() {
        String[] array = args[2].split("=");
        return array[1];
    }
}
