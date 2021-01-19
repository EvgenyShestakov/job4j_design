package ru.job4j.exam;

import java.util.*;

public class Mail {
    public Map<String, Set<String>> merge(Map<String, Set<String>> map) {
        Map<String, Set<String>> rsl = new HashMap<>();
        Map<String, Set<String>> tmp = new HashMap<>(map);
        for (Map.Entry<String, Set<String>> pair : map.entrySet()) {
            Set<String> value = new HashSet<>(pair.getValue());
            String key = pair.getKey();
            if (tmp.containsKey(key)) {
                for (Map.Entry<String, Set<String>> pair2 : map.entrySet()) {
                    Set<String> value2 = pair2.getValue();
                    String key2 = pair2.getKey();
                    if (!key.equals(key2) && value.removeAll(value2)) {
                        value.addAll(value2);
                        tmp.remove(key2);
                    }
                }
                rsl.put(key, value);
            }
        }
        return rsl;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
