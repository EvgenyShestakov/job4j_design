package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Map<String, String> map = new HashMap<>();
        boolean rsl = true;
        for (String string : origin.replaceAll("\\p{Punct}", "").split("\\s")) {
            map.putIfAbsent(string, null);
        }
        for (String string : line.replaceAll("\\p{Punct}", "").split("\\s")) {
            if (!map.containsKey(string)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
