package ru.job4j.kiss;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return find(value, comparator, integer -> integer < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return find(value, comparator, integer -> integer > 0);
    }

    private <T> T find(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T result = null;
        if (value != null && !value.isEmpty()) {
            result = value.get(0);
            for (T elem : value) {
                if (predicate.test(comparator.compare(result, elem))) {
                    result = elem;
                }
            }
        }
        return result;
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
