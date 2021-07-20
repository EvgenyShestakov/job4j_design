package ru.job4j.ood.lsp.parking;

public abstract class Car {
    private String name;
    private int size;

    public Car(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
