package ru.job4j.ood.isp.menu;

public class Graphic extends MenuItems implements Action {
    public Graphic() {
        name = "-- 4.2 Graphic";
    }

    @Override
    public boolean startAction() {
        System.out.println("Selecting graphic settings" + System.lineSeparator());
        return true;
    }
}
