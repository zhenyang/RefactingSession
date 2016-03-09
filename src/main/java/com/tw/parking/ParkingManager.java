package com.tw.parking;

import java.util.List;

public class ParkingManager implements Parkable {
    private List<Parkable> parkingBoy;

    public ParkingManager(List<Parkable> parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public Ticket park(Car car) {
        for (Parkable boy : parkingBoy) {
            Ticket ticket = boy.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return null;
    }


    public Car unPark(Ticket ticket) {
        for (Parkable boy : parkingBoy) {
            Car car = boy.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void accept(Report report) {
        report.visitParkingManager(parkingBoy);
    }

}
