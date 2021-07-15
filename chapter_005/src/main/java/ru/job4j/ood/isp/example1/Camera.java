package ru.job4j.ood.isp.example1;

public class Camera implements Phone {
    @Override
    public void browseInternet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void call() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void takePhoto() {
        System.out.println("Создание фтографии");
    }
}
