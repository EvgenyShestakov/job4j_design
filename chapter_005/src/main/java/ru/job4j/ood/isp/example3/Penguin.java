package ru.job4j.ood.isp.example3;

public class Penguin implements Bird {
    @Override
    public void go() {
        System.out.println("Ходьба");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        System.out.println("Плавание");
    }
}
