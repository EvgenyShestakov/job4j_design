package ru.job4j.ood.dip.example3;

import java.util.List;

public class ListStorage implements Storage {
    List<Employee> employees;

    @Override
    public boolean add(Employee employee) {
        return false;
    }
}
