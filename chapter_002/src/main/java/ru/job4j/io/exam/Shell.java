package ru.job4j.io.exam;

public class Shell {
    private String path = "/";

    public void cd(String string) {
        if (string.equals("/") || string.equals("..") || string.endsWith("..")) {
            path = "/";
        } else if (path.equals("/")) {
            path = String.format("%s%s", "/", string);
        } else {
            path = String.format("%s%s%s", path, "/", string);
        }
    }

    public String pwd() {
        return path;
    }
}
