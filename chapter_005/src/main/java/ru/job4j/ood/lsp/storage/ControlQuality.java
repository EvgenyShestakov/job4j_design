package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControlQuality {
    private final Storage shop = new Shop();
    private final Storage warehouse = new Warehouse();
    private final Storage trash = new Trash();

    public void distribution(Food food) {
        Storage storage = check(food);
        storage.add(food);
    }

    private Storage check(Food food) {
        Storage storage = null;
        LocalDate expiryDate = food.getExpiryDate();
        LocalDate createDate = food.getCreateDate();
        LocalDate now = LocalDate.now();
        long lifeTime = ChronoUnit.DAYS.between(createDate, expiryDate);
        long remain = ChronoUnit.DAYS.between(now, expiryDate);
        double percent = (double) remain / lifeTime * 100;
        if (percent <= 0) {
            storage = trash;
        } else if (percent > 75) {
            storage = warehouse;
        } else if (percent >= 25) {
            storage = shop;
        } else if (percent < 25) {
            food.setDiscount(20);
            storage = shop;
        }
        return storage;
    }

    public Storage getShop() {
        return shop;
    }

    public Storage getWarehouse() {
        return warehouse;
    }

    public Storage getTrash() {
        return trash;
    }

    public static void main(String[] args) {
        Fish fish = new Fish("Herring", LocalDate.of(2021, 11, 9),
                LocalDate.of(2021, 1, 15), 400);
        Fruit fruit = new Fruit("Apple",  LocalDate.of(2021, 7, 15),
                LocalDate.of(2021, 6, 11), 100);
        Milk milk = new Milk("Valio",  LocalDate.of(2018, 9, 6),
                LocalDate.of(2017, 3, 17), 70);
        Bread bread = new Bread("Borodinsky",  LocalDate.of(2021, 7, 25),
                LocalDate.of(2021, 7, 10), 50);
        ControlQuality control = new ControlQuality();
        control.distribution(fish);
        control.distribution(milk);
        control.distribution(bread);
        control.distribution(fruit);
        System.out.println("Мусор " + control.getTrash().get());
        System.out.println("Склад " + control.getWarehouse().get());
        System.out.println("Магазин " + control.getShop().get());
    }
}



