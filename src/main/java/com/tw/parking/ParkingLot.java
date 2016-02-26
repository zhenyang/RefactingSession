package com.tw.parking;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Car> cars;
    private int size;

    public ParkingLot(int size) {
        this.size = size;
        this.cars = new ArrayList<Car>();
    }

    public Ticket park(Car car) {
        if (isFull()) {
            return null;
        }
        cars.add(car);
        return new Ticket(car);
    }

    public Car unPark(Ticket ticket) {
        Car carInTicket = ticket.getCar();
        if (!cars.contains(carInTicket)) {
            return null;
        }
        cars.remove(carInTicket);
        return carInTicket;
    }

    public boolean isFull() {
        return cars.size() == size;
    }

    public int getLeftLotSize() {
        return size - cars.size();
    }
}
