package ru.job4j.ood.isp.menu;

public class NewGame extends MenuItems implements Action {
    public NewGame() {
        name = "- 2 New Game";
    }

    @Override
    public boolean startAction() {
        System.out.println("The game begins" + System.lineSeparator());
        return true;
    }

}
