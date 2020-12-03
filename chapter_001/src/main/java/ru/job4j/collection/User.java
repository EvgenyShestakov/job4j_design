package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;

    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && name.equals(user.name)
                && birthday.equals(user.birthday);
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User user1 = new User("Наташа", 2, new GregorianCalendar(1995, Calendar.
                APRIL, 23));
        User user2 = new User("Наташа", 2, new GregorianCalendar(1995, Calendar.
                APRIL, 23));
        map.put(user1, new MedicalCard(5));
        map.put(user2, new MedicalCard(5));
        for (Map.Entry<User, Object> pair : map.entrySet()) {
            User key = pair.getKey();
            Object value = pair.getValue();
            System.out.println(key + ":" + value);
        }


    }
}
