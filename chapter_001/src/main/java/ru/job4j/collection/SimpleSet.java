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
        for (Object element : simpleArray) {
            if (Objects.equals(element, model)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}