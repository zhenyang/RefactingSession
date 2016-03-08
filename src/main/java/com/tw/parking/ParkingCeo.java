package com.tw.parking;

import java.util.List;

public class ParkingCeo {
    private List<ParkingManager> parkingManager;

    public ParkingCeo(List<ParkingManager> parkingManager) {
        this.parkingManager = parkingManager;
    }

    public Ticket park(Car car) {
        for (ParkingManager manager : parkingManager) {
            Ticket ticket = manager.park(car);
            if (ticket != null) {
                return ticket;
            }

        }
        return null;
    }

    public Car unPark(Ticket ticket) {
        for (ParkingManager manager : parkingManager) {
            Car car = manager.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;

    }
}
