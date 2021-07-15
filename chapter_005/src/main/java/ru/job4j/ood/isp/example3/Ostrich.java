package ru.job4j.ood.isp.example3;

public class Ostrich implements Bird {
    @Override
    public void go() {
        System.out.println("Ходьба");
    }

    @Override
    public void run() {
        System.out.println("Бег");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException();
    }
}
