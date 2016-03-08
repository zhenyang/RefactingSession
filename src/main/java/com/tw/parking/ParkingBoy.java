package com.tw.parking;

import com.google.common.base.Strings;
import com.tw.parking.chooser.Chooser;

import java.util.List;

public class ParkingBoy implements Parkable {
    private final Chooser chooser;
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots, Chooser chooser) {
        this.parkingLots = parkingLots;
        this.chooser = chooser;
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot parkingLot = chooser.chooseParkingLot(parkingLots);
        return parkingLot.park(car);
    }

    @Override
    public Car unPark(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public String report(int level) {
        StringBuilder result = new StringBuilder("");
        result.append(Strings.repeat("--", level)).append("ParkingBoy\n");
        for (ParkingLot parkingLot : parkingLots) {
            result.append(parkingLot.report(level + 1));
        }
        return result.toString();
    }

}
