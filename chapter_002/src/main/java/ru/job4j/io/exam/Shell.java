package ru.job4j.io.exam;

import java.util.Stack;

public class Shell {
    private Stack<String> path = new Stack<>();
    { path.push("/"); }

    public void cd(String string) {
        if (string.equals("/")) {
            while (path.size() > 1) {
                path.pop();
            }
        } else {
            String[] array = string.split("/");
            for (String step : array) {
                path.push(step);
            }
            boolean flag = true;
            while (path.peek().equals("..")) {
                path.pop();
                if (!path.peek().equals("..") && !path.peek().equals("/") && flag) {
                    path.pop();
                    flag = false;
                }
            }
        }
    }

    public String pwd() {
        StringBuilder stringBuilder = new StringBuilder();
        String folder = "";
        for (String step : path) {
            if (step.equals("/") || folder.equals("/")) {
                folder = step;
            } else {
                folder = String.format("%s%s", "/", step);
            }
            stringBuilder.append(folder);
        }
        return stringBuilder.toString();
    }
}
