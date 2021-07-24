package ru.job4j.ood.isp.menu;

public class Continue extends MenuItems implements Action {
    public Continue() {
        name = "- 1 Continue";
    }

    @Override
    public boolean startAction() {
        System.out.println("The game continues" + System.lineSeparator());
        return true;
    }
}
