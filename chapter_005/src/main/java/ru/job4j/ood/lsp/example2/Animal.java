package ru.job4j.ood.lsp.example2;

public class Animal {
    public int riverJumpDistance(int speed, int power) {
        int minDistance = 8;
        int distance = speed * power;
        if (distance < minDistance) {
            throw new IllegalArgumentException("Fell into the water");
        }
        return distance;
    }
}
