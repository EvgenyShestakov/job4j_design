package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.Optional;

public class StartUI {
    public void init(Game game, Input input) {
        boolean run = true;
        while (run) {
            game.getAround();
            String number = input.askStr("Select: ");
            Optional<MenuItems> menuItems = game.findBy(number);
            if (menuItems.isPresent()) {
                MenuItems menuItems1 = menuItems.get();
                if (menuItems1 instanceof Action) {
                    run = ((Action) menuItems1).startAction();
                } else {
                    System.out.println("Wrong input");
                }
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game(new MainMenu(List.of(new Continue(), new NewGame(), new Load(),
                new Options(List.of(new GameSetting(), new Graphic(), new Sound(), new Control())),
                new Credits(), new ExitGame())));
        new StartUI().init(game, new ConsoleInput());
    }
}
