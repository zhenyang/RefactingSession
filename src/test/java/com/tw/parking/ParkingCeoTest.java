package com.tw.parking;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class ParkingCeoTest {
    @Test
    public void testShouldManageParkingBoy() throws Exception {
        ParkingLot parkingLot = Helper.createParkingLot(0, 1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot), new NormalChooser());

        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingBoy));

        ParkingCeo parkingCeo = new ParkingCeo(Arrays.asList(parkingManager));

        Car car = new Car();
        Ticket ticket = parkingCeo.park(car);


        assertThat(car, sameInstance(parkingCeo.unPark(ticket)));
    }
}
