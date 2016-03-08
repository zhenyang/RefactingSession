package com.tw.parking;

import com.google.common.base.Strings;

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

    public String report(int level) {
        StringBuilder result = new StringBuilder("");
        result.append(Strings.repeat("--", level)).append("ParkingManager\n");
        for (Parkable parkable : parkingBoy) {
            result.append(parkable.report(level + 1));
        }
        return result.toString();
    }

}
