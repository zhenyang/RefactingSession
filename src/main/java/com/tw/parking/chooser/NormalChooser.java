package com.tw.parking.chooser;

import com.tw.parking.ParkingLot;

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