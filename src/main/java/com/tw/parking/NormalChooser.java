package com.tw.parking;

import java.util.List;

public class NormalChooser implements Chooser {
    @Override
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            if (parkingLot.isFull()) {
                parkingLot = parkingLots.get(i);
            }
        }
        return parkingLot;
    }
}