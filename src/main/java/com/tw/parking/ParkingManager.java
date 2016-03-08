package com.tw.parking;

import java.util.List;

public class ParkingManager {
    private List<ParkingBoy> parkingBoy;

    public ParkingManager(List<ParkingBoy> parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public Ticket park(Car car) {
        for (ParkingBoy boy : parkingBoy) {
            Ticket ticket = boy.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return null;
    }


    public Car unPark(Ticket ticket) {
        for (ParkingBoy boy : parkingBoy) {
            Car car = boy.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}
