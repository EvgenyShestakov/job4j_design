package ru.job4j.ood.lsp.parking;

public class UndergroundParking implements Parking {
    @Override
    public boolean park(Car car) {
        return false;
    }
}
