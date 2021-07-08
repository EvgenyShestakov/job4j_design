package ru.job4j.ood.lsp.example1;

// В классе Tornado усилено предусловие. Это нарушение контракта.

public class Tornado extends Wind {
    @Override
    public void start(int speed) {
        if (speed < 70) {
            throw new IllegalArgumentException("The wind is not strong enough!");
        }
        System.out.println("The tornado has begun");
    }
}
