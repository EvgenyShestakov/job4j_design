package ru.job4j.ood.isp.example1;

public class Smartphone implements Phone {
    @Override
    public void browseInternet() {
        System.out.println("Выход в интернет");
    }

    @Override
    public void call() {
        System.out.println("Звонок");
    }

    @Override
    public void takePhoto() {
        System.out.println("Создание фтографии");
    }
}
