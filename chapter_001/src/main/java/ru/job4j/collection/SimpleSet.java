package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray simpleArray = new SimpleArray();

    public void add(T model) {
        if (!contains(model)) {
            simpleArray.add(model);
        }
    }

    private boolean contains(T model) {
        boolean flag = false;
        Object[] objects = simpleArray.getArrays();
        for (Object element : objects) {
            if (Objects.equals(element, model)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}