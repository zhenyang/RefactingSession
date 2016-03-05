package com.tw.parking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class ParkingDoctorTest {
    @Test
    public void test_should_park_car() throws Exception {
        ParkingLot parkingLot1 = createParkingLot(3, 10);
        ParkingLot parkingLot2 = createParkingLot(1, 5);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new SmartestChooser());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertThat(parkingLot2.unPark(ticket), sameInstance(car));
    }

    private ParkingLot createParkingLot(int parkedCars, int size) {
        ParkingLot parkingLot = new ParkingLot(size);
        for (int i = 0; i < parkedCars; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }
        return parkingLot;
    }
}
