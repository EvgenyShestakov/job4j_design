package ru.job4j.ood.isp.menu;

public class Load extends MenuItems implements Action {
    public Load() {
        name = "- 3 Load";
    }

    @Override
    public boolean startAction() {
        System.out.println("Loading a new game" + System.lineSeparator());
        return true;
    }
}
