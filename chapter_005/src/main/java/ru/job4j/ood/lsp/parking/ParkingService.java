package ru.job4j.ood.lsp.parking;

import java.util.Map;

public class ParkingService {
    Map<String, Parking> parkings;

    public ParkingService(Map<String, Parking> parkings) {
        this.parkings = parkings;
    }

    public String park(Car car, String parkName) {
        String status;
        if (parkings.containsKey(parkName)) {
            Parking parking = parkings.get(parkName);
            status = parking.park(car);
        } else {
            status = "Парковка с данным названием не найдена";
        }
        return status;
    }
}
