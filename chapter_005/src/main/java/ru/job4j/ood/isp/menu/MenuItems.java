package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuItems {
    String name;
    List<MenuItems> children = new ArrayList<>();
}
