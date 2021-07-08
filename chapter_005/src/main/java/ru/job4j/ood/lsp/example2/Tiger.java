package ru.job4j.ood.lsp.example2;

// В классе Tiger ослаблено постусловие.
public class Tiger extends Animal {
    public int riverJumpDistance(int speed, int power) {
        int minDistance = 8;
        int distance = speed * power;
        return distance;
    }
}



