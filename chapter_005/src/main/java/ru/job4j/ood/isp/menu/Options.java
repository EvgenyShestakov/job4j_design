package ru.job4j.ood.isp.menu;

import java.util.List;

public class Options extends  MenuItems implements Action {
    public Options(List<MenuItems> list) {
        name = "- 4 Options";
        children = list;
    }

    @Override
    public boolean startAction() {
        System.out.println("Entering settings" + System.lineSeparator());
        return true;
    }
}
