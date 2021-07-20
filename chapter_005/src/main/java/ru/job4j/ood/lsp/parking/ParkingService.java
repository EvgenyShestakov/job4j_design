package ru.job4j.ood.lsp.parking;

import java.util.Map;

public class ParkingService {
    Map<String, Parking> parkings;

    public ParkingService(Map<String, Parking> parkings) {
        this.parkings = parkings;
    }

    public String park(Car car, String parking) {
        return new String();
    }

    public static void main(String[] args) {
        Car[] place = {new Truck("2565LK5", 2), new Truck("2565LK5", 2),
                new Truck("2565LK5", 2), new Truck("2565LK5", 2),
                null, new Truck("2565LK5", 2), new Truck("2565LK5", 2),
                null, null, null, null};
        Truck truck = new Truck("3770FH7", 4);
        int size = truck.getSize();
        int down = 0;
        int up = 0;
        for (int i = 0; i < place.length - 1 && up == 0; i++) {
            int x = 1;
            if (place[i] == null) {
                for (int j = i; j < place.length - 1; j++) {
                    if (place[j] == null && place[j + 1] == null) {
                        x++;
                        if (x == size) {
                            down = i;
                            up = i + size;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (up != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Грузовик припаркован на местах для легковых машин под номерами");
            for (int i = down; i < up; i++) {
                place[i] = truck;
                stringBuilder.append(" ").append(i);
            }
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println("Недостаточно мест на парковке");
        }
    }
}
