package com.tw.parking;

import java.util.List;

public interface Chooser {
    ParkingLot chooseParkingLot(List<ParkingLot> parkingLots);
}
