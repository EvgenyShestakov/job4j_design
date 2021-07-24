package ru.job4j.ood.isp.menu;

import java.util.*;

public class Game {
    private  MenuItems root;

    public Game(MenuItems menuItems) {
        this.root = menuItems;
    }

    public void getAround() {
        Deque<MenuItems> data = new ArrayDeque<>();
        data.offer(this.root);
        boolean flag = true;
        while (!data.isEmpty()) {
            MenuItems el = data.poll();
            System.out.println(el.name);
            if (flag) {
                data.addAll(el.children);
                flag = false;
            } else {
                for (int i = el.children.size() - 1; i >= 0; i--) {
                    data.addFirst(el.children.get(i));
                }
            }
        }
    }

    public Optional<MenuItems> findBy(String string) {
        Queue<MenuItems> data = new LinkedList<>();
        Optional<MenuItems> rsl = Optional.empty();
        data.offer(this.root);
        while (!data.isEmpty()) {
            MenuItems el = data.poll();
            String[] mass = el.name.split("\\s");
            if (mass[1].equals(string)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}


