package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] arrays;
    private int size = 0;

    public SimpleArray(int size) {
        arrays = new Object[size];
    }

    public void add(T model) {
        this.arrays[size++] = model;
    }

    public void set(int index, T model) {
        int index1 = Objects.checkIndex(index, arrays.length);
        arrays[index1] = model;
    }

    public void remove(int index) {
        int index1 = Objects.checkIndex(index, arrays.length);
        System.arraycopy(arrays, index1 + 1, arrays, index1, size - index1 - 1);
        arrays[size - 1] = null;
        size--;
    }

    public T get(int index) {
        int index1 = Objects.checkIndex(index, arrays.length);
        return (T) arrays[index1];
    }
    @Override
    public SimpleArrayIterator iterator() {
        return new SimpleArrayIterator();
    }

    public class SimpleArrayIterator implements Iterator<T> {
        private int point = 0;

        @Override
        public boolean hasNext() {
            return point < arrays.length;
        }

        @Override
        public T next() {
            return (T) arrays[point++];
        }
    }
}
