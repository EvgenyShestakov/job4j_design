package ru.job4j.ood.lsp.storage;

import java.util.List;

public interface Storage {
    void add(Food food);
    boolean accept(Food food);
    List<Food> get();
}
