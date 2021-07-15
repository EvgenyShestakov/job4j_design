package ru.job4j.ood.isp.example2;

public class Fighter implements CombatAircraft {
    @Override
    public void airMissileLaunch() {
        System.out.println("Применение ракеты воздух-воздух");
    }

    @Override
    public void droppingBombs() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void usOfGuns() {
        System.out.println("Применение пушки");
    }

    @Override
    public void missileLaunchOnAGroundTarget() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unguidedMissileLaunch() {
        throw new UnsupportedOperationException();
    }
}
