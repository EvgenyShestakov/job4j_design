package ru.job4j.ood.isp.menu;

public class Control extends MenuItems implements Action {
    public Control() {
        name = "-- 4.4 Control"; }

    @Override
    public boolean startAction() {
        System.out.println("Key assignment" + System.lineSeparator());
        return true;
    }
}
