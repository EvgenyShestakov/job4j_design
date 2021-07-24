package ru.job4j.ood.isp.menu;

public class Sound extends MenuItems implements Action {
    public Sound() {
        name = "-- 4.3 Sound";
    }

    @Override
    public boolean startAction() {
        System.out.println("Sound setting" + System.lineSeparator());
        return true;
    }
}
