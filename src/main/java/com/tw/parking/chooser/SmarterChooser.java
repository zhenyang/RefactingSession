package com.tw.parking.chooser;

import com.tw.parking.ParkingLot;
import com.tw.parking.chooser.Chooser;

import java.util.List;

public class SmarterChooser implements Chooser {

    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            ParkingLot temp = parkingLots.get(i);
            if (temp.getLeftLotSize() > parkingLot.getLeftLotSize()) {
                parkingLot = temp;
            }
        }
        return parkingLot;
    }
}