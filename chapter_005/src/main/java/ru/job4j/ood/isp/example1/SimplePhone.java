package ru.job4j.ood.isp.example1;

public class SimplePhone implements Phone {
    @Override
    public void browseInternet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void call() {
        System.out.println("Звонок");
    }

    @Override
    public void takePhoto() {
        throw new UnsupportedOperationException();
    }
}
