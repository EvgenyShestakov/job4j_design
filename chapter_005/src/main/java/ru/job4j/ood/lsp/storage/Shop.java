package ru.job4j.ood.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    public List<Food> list = new ArrayList<>();

    @Override
    public void add(Food food) {
        list.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean flag = false;
        double percent = food.expirationPercentage();
        if (percent >= 25 && percent <= 75) {
            flag = true;
        } else if (percent < 25 && percent > 0) {
            flag = true;
            food.setDiscount(20);
        }
        return flag;
    }

    @Override
    public List<Food> get() {
        return list;
    }
}
