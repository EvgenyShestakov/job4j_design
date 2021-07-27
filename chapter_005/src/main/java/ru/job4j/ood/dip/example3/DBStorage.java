package ru.job4j.ood.dip.example3;

import java.sql.Connection;

public class DBStorage implements  Storage {
    private Connection connection;

    @Override
    public boolean add(Employee employee) {
        return false;
    }
}
