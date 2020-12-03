package ru.job4j.collection;

 public class SimpleQueue<T>  {
   private final SimpleStack<T> in = new SimpleStack<>();
   private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T t = null;
    return t;
    }

     public void push(T value) {
        in.push(value);
    }
}

