package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap();
        boolean rsl = true;
        if (left.length() != right.length()) {
            rsl = false;
        } else {
            for (Character character : left.toCharArray()) {
                if (!map.containsKey(character)) {
                    map.put(character, 1);
                } else {
                    map.computeIfPresent(character, (character1, integer) -> integer + 1);
                }
            }
            for (Character character : right.toCharArray()) {
                if (!map.containsKey(character)) {
                    rsl = false;
                    break;
                } else {
                    map.computeIfPresent(character, (character1, integer) -> integer - 1);
                }
            }
            if (rsl) {
                for (Character character : map.keySet()) {
                    if (map.get(character) != 0) {
                        rsl = false;
                        break;
                    }
                }
            }
        }
        return rsl;
    }
}
