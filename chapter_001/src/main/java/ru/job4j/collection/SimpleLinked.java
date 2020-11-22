package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinked<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;
    private int modCount;

    public void add(T model) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, model, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        int index1 = Objects.checkIndex(index, size);
        T t = null;
        Iterator<T> it = this.iterator();
        int count = 0;
        while (count <= index1) {
            t = it.next();
            count++;
        }
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleLinkedIterator();
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public class SimpleLinkedIterator implements Iterator<T> {
        private Node<T> cursor = null;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != last;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (cursor == null) {
                cursor = first;
            } else {
                cursor = cursor.next;
            }
            return cursor.item;
        }
    }
}
