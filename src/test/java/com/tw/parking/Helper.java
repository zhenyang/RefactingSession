package com.tw.parking;

public class Helper {
    static ParkingLot createParkingLot(int parkedCars, int size) {
        ParkingLot parkingLot = new ParkingLot(size);
        for (int i = 0; i < parkedCars; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }
        return parkingLot;
    }
}
