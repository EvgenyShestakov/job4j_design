package ru.job4j.ood.isp.menu;

import java.util.List;

public class MainMenu extends MenuItems {
    public MainMenu(List<MenuItems> list) {
    name = "MAIN MENU :";
    children = list;
    }
}
