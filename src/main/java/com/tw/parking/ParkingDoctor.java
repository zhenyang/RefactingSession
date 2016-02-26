package com.tw.parking;

import java.util.List;

public class ParkingDoctor extends ParkingBoy {
    public ParkingDoctor(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            ParkingLot temp = parkingLots.get(i);
            if (temp.getEmptyRatio() > parkingLot.getEmptyRatio()) {
                parkingLot = temp;
            }
        }
        return parkingLot.park(car);
    }
}
