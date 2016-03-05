package com.tw.parking;

import java.util.List;

public class SmartestChooser implements Chooser{
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            ParkingLot temp = parkingLots.get(i);
            if (temp.getEmptyRatio() > parkingLot.getEmptyRatio()) {
                parkingLot = temp;
            }
        }
        return parkingLot;
    }
}