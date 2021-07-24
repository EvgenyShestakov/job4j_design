package ru.job4j.ood.isp.menu;

public class ExitGame extends MenuItems implements Action {
    public ExitGame() {
        name = "- 6 Exit Game" + System.lineSeparator();
    }

    @Override
    public boolean startAction() {
        System.out.println("End the game" + System.lineSeparator());
        return false;
    }
}
