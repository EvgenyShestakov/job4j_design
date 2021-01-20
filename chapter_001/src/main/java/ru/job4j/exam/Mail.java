package ru.job4j.exam;

import java.util.*;

public class Mail {
    public List<User> merge(List<User> users) {
        Map<String, User> aux = new HashMap<>();
        Map<User, Set<String>> main = new HashMap<>();
        List<User> list = new ArrayList<>();
        for (User user : users) {
            User current = user;
            Set<String> mails = current.getMails();
            for (String mail : mails) {
                if (!aux.containsKey(mail)) {
                    aux.put(mail, current);
                } else {
                    current = aux.get(mail);
                    Set<String> oldMails = current.getMails();
                    oldMails.addAll(mails);
                    for (String mail1 : oldMails) {
                        aux.put(mail1, current);
                    }
                    break;
                }
            }
            main.put(current, current.getMails());
        }
        for (var key: main.keySet()) {
            list.add(new User(key.getName(), main.get(key)));
        }
        return list;
    }

    public static class User {
        private String name;
        private Set<String> mails;

        public User(String name, Set<String> mail) {
            this.name = name;
            this.mails = mail;
        }

        public String getName() {
            return name;
        }

        public Set<String> getMails() {
            return mails;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + ", mail=" + mails
                    + '}';
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
            return Objects.equals(getName(), user.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }
    }
}
