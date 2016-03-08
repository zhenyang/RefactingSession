package com.tw.parking.chooser;

import com.tw.parking.ParkingLot;

import java.util.List;

public interface Chooser {
    ParkingLot chooseParkingLot(List<ParkingLot> parkingLots);
}
