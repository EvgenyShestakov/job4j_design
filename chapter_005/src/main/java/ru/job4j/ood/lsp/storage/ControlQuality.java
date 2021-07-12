package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality {
    private final List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void distribution(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                storage.add(food);
            }
        }
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
        ControlQuality control = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        control.distribution(fish);
        control.distribution(milk);
        control.distribution(bread);
        control.distribution(fruit);
        control.storages.forEach(storage -> System.out.println(storage.get()));
    }
}



