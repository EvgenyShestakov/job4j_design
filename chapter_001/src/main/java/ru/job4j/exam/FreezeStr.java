package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        boolean rsl = true;
        if (left.length() != right.length()) {
            rsl = false;
        } else {
            for (Character character : left.toCharArray()) {
                map.put(character, map.getOrDefault(character, 0) + 1);
            }
        }
        for (Character character : right.toCharArray()) {
            if (!map.containsKey(character)) {
                rsl = false;
                break;
            } else {
                int value = map.get(character) - 1;
                if (value == 0) {
                    map.remove(character);
                } else {
                    map.put(character, value);
                }
            }
        }
        if (rsl) {
            rsl = map.isEmpty();
        }
        return rsl;
    }
}

