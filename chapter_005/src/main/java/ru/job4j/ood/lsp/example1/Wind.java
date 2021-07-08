package ru.job4j.ood.lsp.example1;

public class Wind {
    public void start(int speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("The wind is not strong enough!");
        }
        System.out.println("Wind started to blow");
    }
}

