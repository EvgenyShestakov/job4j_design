package ru.job4j.ood.lsp.carparking;

public class Truck extends Car {
    private int size;
    public Truck(String name, String type, int size) {
        super(name, type);
        if (size < 2) {
            throw new IllegalArgumentException("Размер грузовой машины не может быть меньше 2");
        }
            this.size = size;


    }
}
