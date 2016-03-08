package com.tw.parking;

import com.tw.parking.chooser.NormalChooser;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class ParkingManagerTest {
    @Test
    public void testShouldManageParkingBoy() throws Exception {
        ParkingLot parkingLot = Helper.createParkingLot(0, 1);
        Parkable parkingBoy = new ParkingBoy(Arrays.asList(parkingLot), new NormalChooser());

        Parkable parkingManager = new ParkingManager(Arrays.asList(parkingBoy));

        Car car = new Car();
        Ticket ticket = parkingManager.park(car);


        assertThat(car, sameInstance(parkingManager.unPark(ticket)));
    }
}
