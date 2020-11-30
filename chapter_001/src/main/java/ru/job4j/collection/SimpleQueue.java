package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T t = null;
        while (true) {
            if (t == null) {
                out.push(in.pop());
                if (in.isEmpty()) {
                    t = out.pop();
                }
            } else {
                if (out.isEmpty()) {
                    break;
                }
                in.push(out.pop());
            }
        }
        return t;
    }

    public void push(T value) {
        in.push(value);
    }
}
