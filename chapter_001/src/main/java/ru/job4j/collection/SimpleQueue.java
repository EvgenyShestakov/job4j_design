package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T t = null;
        while (true) {
            if (t == null) {
                out.push(in.pop());
                if (in.getSize() == 0) {
                    t = out.pop();
                }
            } else {
                if (out.getSize() == 0) {
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

    public static void main(String[] args) {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        System.out.println();
        int rsl = queue.poll();
        System.out.println(rsl);
    }
}
