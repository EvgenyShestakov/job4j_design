package ru.job4j.collection;

import java.util.*;

public class Analysis {
    public Info diff(List<User> previous, List<User> current) {
        int add = 0;
        int chan = 0;
        int del = 0;
        for (int i = 0; i < current.size(); i++) {
            User cur = current.get(i);
            boolean flag = true;
            if (!previous.contains(cur)) {
                for (int j = 0; j < previous.size(); j++) {
                    User prev = previous.get(j);
                    if (cur.id == prev.id && (!Objects.equals(cur.name, prev.name))) {
                        chan++;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    add++;
                }
            }
        }
        for (int i = 0; i < previous.size(); i++) {
            User prev = previous.get(i);
            boolean flag = true;
            if (!current.contains(prev)) {
                for (int j = 0; j < current.size(); j++) {
                    User cur = current.get(j);
                    if (cur.id == prev.id && (!Objects.equals(cur.name, prev.name))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    del++;
                }
            }
        }
        return new Info(add, chan, del);
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
