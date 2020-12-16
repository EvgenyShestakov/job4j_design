package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable {
    private Object[] arrays = new Object[1000];
    private int size = 0;
    private float threshold = arrays.length / 5.0f;
    private int modCount = 0;

    public boolean insert(K key, V value) {
        boolean flag = false;
        if (size >= threshold) {
            arrays = grow();
        }
        int hash = hash(key);
        if (arrays[hash] == null) {
            arrays[hash] = new Node<>(key, value);
            flag = true;
            size++;
            modCount++;
        }
        return flag;
    }

    public V get(K key) {
        V value = null;
        int hash = hash(key);
        Node<K, V> node = (Node<K, V>) arrays[hash];
        if (key.hashCode() == node.key.hashCode()) {
            if (key.equals(node.key)) {
                value = node.value;
            }
        }
        return value;
    }

    public boolean delete(K key) {
        boolean flag = false;
        int hash = hash(key);
        Node<K, V> node = (Node<K, V>) arrays[hash];
        if (key.hashCode() == node.key.hashCode()) {
            if (key.equals(node.key)) {
                arrays[hash] = null;
                flag = true;
            }
        }
        size--;
        modCount++;
        return  flag;
    }

    private int hash(K key) {
        return (key == null) ? 0 : key.hashCode() % arrays.length;
    }

    private Object[] grow() {
        Object[] newArrays = new Object[arrays.length * 2];
        threshold = newArrays.length / 5.0f;
        int newSize = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                Node<K, V> node = (Node<K, V>) arrays[i];
                int newHash = node.key.hashCode() % newArrays.length;
                if (newArrays[newHash] == null) {
                    newArrays[newHash] = new Node<>(node.key, node.value);
                    newSize++;
                }
            }
        }
        size = newSize;
        return newArrays;
    }

    @Override
    public Iterator iterator() {
        return new SimpleHashMapIterator();
    }

    static class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public class SimpleHashMapIterator implements Iterator {
        private int point = 0;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            while (point < arrays.length && arrays[point] == null) {
                point++;
            }
            return point < arrays.length;
        }

        @Override
        public Node<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (Node<K, V>) arrays[point++];
        }
    }
}
