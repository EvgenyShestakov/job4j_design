package ru.job4j.ood.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    List<Food> list = new ArrayList<>();

    @Override
    public void add(Food food) {
        list.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean flag = false;
        double percent = food.expirationPercentage();
        if (percent > 75) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Food> get() {
        return list;
    }
}
