package ru.job4j.ood.isp.example3;

public class Eagle implements Bird {
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
        System.out.println("Полет");
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException();
    }
}
