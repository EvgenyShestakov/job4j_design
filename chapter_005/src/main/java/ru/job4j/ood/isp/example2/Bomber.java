package ru.job4j.ood.isp.example2;

public class Bomber implements CombatAircraft {
    @Override
    public void airMissileLaunch() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void droppingBombs() {
        System.out.println("Применение бомбы");
    }

    @Override
    public void usOfGuns() {
        System.out.println("Применение пушки");
    }

    @Override
    public void missileLaunchOnAGroundTarget() {
        System.out.println("Применение ракеты воздух-земля");
    }

    @Override
    public void unguidedMissileLaunch() {
        throw new UnsupportedOperationException();
    }
}
