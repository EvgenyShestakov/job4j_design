package ru.job4j.ood.lsp.parking;

public class UndergroundParking implements Parking {
    int[] passPlace;
    int[] truckPlace;

    public UndergroundParking(int passPlace, int truckPlace) {
        this.passPlace = new int[passPlace];
        this.truckPlace = new int[truckPlace];
    }

    @Override
    public boolean park(Car car) {
        return false;
    }
}
