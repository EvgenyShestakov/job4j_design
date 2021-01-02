package ru.job4j.collection;

import java.util.*;

public class Analysis {
    public Info diff(List<User> previous, List<User> current) {
        int chan = 0;
        int del = 0;
        Map<Integer, User> map = new HashMap<>();
        for (User user : current) {
            map.put(user.id, user);
        }
        for (User user : previous) {
            if (map.containsValue(user)) {
                map.remove(user.id);
            } else if (map.containsKey(user.id) && !map.containsValue(user)) {
                chan++;
                map.remove(user.id);
            } else {
                del++;
            }
        }
        return new Info(map.size(), chan, del);
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

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Info)) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
