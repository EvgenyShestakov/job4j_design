package ru.job4j.ood.dip.example3;

import java.util.Map;

public class HashMapStorage implements Storage {
    Map<Integer, Employee> employees;

    @Override
    public boolean add(Employee employee) {
        return false;
    }
}
