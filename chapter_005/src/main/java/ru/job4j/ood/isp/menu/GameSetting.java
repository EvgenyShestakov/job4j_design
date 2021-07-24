package ru.job4j.ood.isp.menu;

public class GameSetting extends MenuItems implements Action {
    public GameSetting() {
        name = "-- 4.1 Game Setting";
    }

    @Override
    public boolean startAction() {
        System.out.println("Difficulty level selection" + System.lineSeparator());
        return true;
    }
}
