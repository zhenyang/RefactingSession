package com.tw.parking;

import java.util.List;

public class ParkingMaster extends ParkingBoy {
    public ParkingMaster(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            ParkingLot temp = parkingLots.get(i);
            if (temp.getLeftLotSize() > parkingLot.getLeftLotSize()) {
                parkingLot = temp;
            }
        }
        return parkingLot.park(car);
    }

}
