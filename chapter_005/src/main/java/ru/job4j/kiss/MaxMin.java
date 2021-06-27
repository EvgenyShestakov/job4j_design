package ru.job4j.kiss;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T max = null;
        if (!value.isEmpty()) {
            max = value.get(0);
            for (T elem: value) {
                if (comparator.compare(max, elem) < 0) {
                    max = elem;
                }
            }
        }
        return max;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T min = null;
        if (!value.isEmpty()) {
            min = value.get(0);
            for (T elem : value) {
                if (comparator.compare(min, elem) > 0) {
                    min = elem;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MaxMin maxMin = new MaxMin();
        List<String> list = Arrays.asList("c", "f", "c", "a", "g", "p");
        String s = maxMin.max(list, String::compareTo);
        System.out.println(s);
        String s1 = maxMin.min(list, String::compareTo);
        System.out.println(s1);
    }
}
