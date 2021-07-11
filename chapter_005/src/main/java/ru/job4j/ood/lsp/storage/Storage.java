package ru.job4j.ood.lsp.storage;

import java.util.List;

public interface Storage {
    public void add(Food food);
    public List<Food> get();
}
