package ru.job4j.ood.isp.menu;

public class Credits extends MenuItems implements Action {
    public Credits() {
        name = "- 5 Credits";
    }

    @Override
    public boolean startAction() {
        System.out.println("Game creators..." + System.lineSeparator());
        return true;
    }
}
