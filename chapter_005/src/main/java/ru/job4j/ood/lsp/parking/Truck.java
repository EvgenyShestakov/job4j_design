package ru.job4j.ood.lsp.parking;

public class Truck extends Car {
    private int size;
    public Truck(String name, int size) {
        super(name);
        if (size < 2) {
            throw new IllegalArgumentException("Размер грузовой машины не может быть меньше 2");
        }
            this.size = size;
    }
}
