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
        assertThat(status, is("Машина припаркована на месте под номером 0"));
    }

    @Test
    public void whenPassParkingFailed() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(1, 20)));
        Car pass1 = new PassengerCar("5824HY9");
        parkingService.park(pass1, "Гарант");
        Car pass2 = new PassengerCar("1983RT4");
        String status = parkingService.park(pass2, "Гарант");
        assertThat(status, is("На парковке нет мест для машин"));
    }

    @Test
    public void whenThereIsNoSuchParking() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 20)));
        Car pass = new PassengerCar("1983RT4");
        String status = parkingService.park(pass, "Колесо");
        assertThat(status, is("Парковка с данным названием не найдена"));
    }

    @Test
    public void whenTheTruckParkingWasSuccessful() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 20)));
        Car truck = new Truck("2565LK5", 2);
        String status = parkingService.park(truck, "Гарант");
        assertThat(status, is("Машина припаркована на месте под номером 0"));
    }

    @Test
    public void whenTruckParkingFailed() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(1, 1)));
        Car truck1 = new Truck("2594KG8", 2);
        parkingService.park(truck1, "Гарант");
        Car truck2 = new Truck("2565LK5", 2);
        String status = parkingService.park(truck2, "Гарант");
        assertThat(status, is("На парковке нет мест для машин"));
    }

    @Test
    public  void whenTheTruckIsParkedForASpaceForCars() {
        ParkingService parkingService = new ParkingService(Map.of("Гарант",
                new UndergroundParking(20, 0)));
        Car truck = new Truck("2565LK5", 2);
        String status = parkingService.park(truck, "Гарант");
        assertThat(status, is("Грузовик припаркован на местах для легковых машин под номерами 0 1"));
    }
}
