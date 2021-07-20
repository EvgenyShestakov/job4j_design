package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {
    @Test
    public void whenThePassParkingWasSuccessful() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 20)));
        Car pass = new PassengerCar("1983RT4");
        String status = parkingService.park(pass, "Гарант");
        assertThat(status, is("Машина поставлена на парковку"));
    }

    @Test
    public void whenPassParkingFailed() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 20)));
        Car pass = new PassengerCar("1983RT4");
        String status = parkingService.park(pass, "Гарант");
        assertThat(status, is("На парковке нет мест"));
    }

    @Test
    public void whenThereIsNoSuchParking() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 20)));
        Car pass = new PassengerCar("1983RT4");
        String status = parkingService.park(pass, "Гарант");
        assertThat(status, is("Такой парковки не существует"));
    }

    @Test
    public void whenTheTruckParkingWasSuccessful() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 20)));
        Car truck = new Truck("2565LK5", 2);
        String status = parkingService.park(truck, "Гарант");
        assertThat(status, is("Машина поставлена на парковку"));
    }

    @Test
    public void whenTruckParkingFailed() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 20)));
        Car truck = new Truck("2565LK5", 2);
        String status = parkingService.park(truck, "Гарант");
        assertThat(status, is("На парковке нет мест"));
    }

    @Test
    public  void whenTheTruckIsParkedForASpaceForCars() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 20)));
        Car truck = new Truck("2565LK5", 2);
        String status = parkingService.park(truck, "Гарант");
        assertThat(status, is("Грузовик припаркован на местах для легковых машин под номерами 7 8"));
    }
}
