package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray simpleArray = new SimpleArray();

    public void add(T model) {
        boolean flag = true;
        Object[] objects = simpleArray.getArrays();
        for (Object element : objects) {
            if (Objects.equals(element, model)) {
                flag = false;
            }
        }
        if (flag) {
            simpleArray.add(model);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}