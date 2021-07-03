package ru.job4j.ood.ocp.example1;

import ru.job4j.ood.ocp.example1.BMW;

public class Taxi {
    /*Если требуется добавить автомобиль то нужно вносить изменения в класс.
    А можно все классы машин имплементировать от интерфейса Car и в параметры
    метода workInATaxi вписать Car car. В таком случае за добавлением нового
    автомобиля не последует изменение класса Taxi.
     */
    public void workInATaxi(Car car) {
        car.startShift();
    }
}
