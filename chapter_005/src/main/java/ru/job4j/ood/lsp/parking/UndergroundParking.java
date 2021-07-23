package ru.job4j.ood.lsp.parking;

public class UndergroundParking implements Parking {
    Car[] passPlace;
    Car[] truckPlace;

    public UndergroundParking(int passPlace, int truckPlace) {
        this.passPlace = new Car[passPlace];
        this.truckPlace = new Car[truckPlace];
    }

    @Override
    public String park(Car car) {
        String status = put(car);
        if (status.equals("На парковке нет мест для машин") && car.getSize() > 1) {
            status = addIfThereIsNoSpace(car);
        }
        return status;
    }

    private String put(Car car) {
        String status = "На парковке нет мест для машин";
        Car[] place = car.getSize() == 1 ? passPlace : truckPlace;
        for (int i = 0; i < place.length; i++) {
            if (place[i] == null) {
                place[i] = car;
                status = String.format("Машина припаркована на месте под номером %d", i);
                break;
            }
        }
        return status;
    }

    private String addIfThereIsNoSpace(Car car) {
        String status;
        int size = car.getSize();
        int down = 0;
        int up = 0;
        for (int i = 0; i < passPlace.length - 1 && up == 0; i++) {
            int x = 1;
            if (passPlace[i] == null) {
                for (int j = i; j < passPlace.length - 1; j++) {
                    if (passPlace[j] == null && passPlace[j + 1] == null) {
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
                passPlace[i] = car;
                stringBuilder.append(" ").append(i);
            }
            status = stringBuilder.toString();
        } else {
            status = "На парковке нет мест для машин";
        }
        return status;
    }
}
