package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] arrays = new Object[10];
    private int size = 0;
    private int modCount = 0;

    public void add(T model) {
        if (size == arrays.length) {
            arrays = grow();
            arrays[size++] = model;
        } else {
            arrays[size++] = model;
        }
        modCount++;
    }

    public T get(int index) {
        int index1 = Objects.checkIndex(index, size);
        modCount++;
        return (T) arrays[index1];
    }

    public void set(int index, T model) {
        int index1 = Objects.checkIndex(index, size);
        if (size == arrays.length) {
            arrays = grow();
            arrayCopySet(index1, model);
        } else {
            arrayCopySet(index1, model);
        }
        modCount++;
    }

    public void remove(int index) {
        int index1 = Objects.checkIndex(index, size);
        System.arraycopy(arrays, index1 + 1, arrays, index1, size - index1 - 1);
        arrays[size - 1] = null;
        size--;
        modCount++;
    }

    private Object[] grow() {
        Object[] newArrays = new Object[this.arrays.length * 2];
        System.arraycopy(arrays, 0, newArrays, 0, arrays.length);
        return newArrays;
    }

    private void arrayCopySet(int index1, T model) {
        System.arraycopy(arrays, index1, arrays, index1 + 1, size - index1);
        arrays[index1] = model;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    public class SimpleArrayIterator implements Iterator<T> {
        private int point = 0;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return point < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) arrays[point++];
        }
    }
}