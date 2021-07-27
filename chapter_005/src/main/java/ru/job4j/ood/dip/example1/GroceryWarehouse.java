package ru.job4j.ood.dip.example1;

import java.util.List;

public class GroceryWarehouse {
    List<Valio> valio;
    /*На слад может завозиться разное молоко. Выделяем абстракцию и меняем типизацию List
    на Milk.
    List<Milk> milk;
     */

    public GroceryWarehouse(List<Valio> valio) {
        this.valio = valio;
    }
}
