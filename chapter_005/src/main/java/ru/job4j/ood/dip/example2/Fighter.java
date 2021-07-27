package ru.job4j.ood.dip.example2;

public class Fighter {
    /*В будующем бойцу потребуется сменить оружие,поэтому выделяем абстракцию Weapon

    Weapon weapon;

    public Fighter(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
     */
    Rifle rifle;

    public Fighter(Rifle rifle) {
        this.rifle = rifle;
    }
}
