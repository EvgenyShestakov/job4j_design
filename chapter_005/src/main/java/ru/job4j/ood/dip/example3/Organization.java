package ru.job4j.ood.dip.example3;

import java.util.Map;

public class Organization {
    /*Выделяем абстракцию для храниния информации о сотрудниках.
Storage storage;

public Organization(Storage storage) {
        this.storage = storage;
    }
     */
    Map<Integer, Employee> employees;

    public Organization(Map<Integer, Employee> employees) {
        this.employees = employees;
    }
}
