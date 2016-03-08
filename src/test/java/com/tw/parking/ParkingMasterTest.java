package com.tw.parking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class ParkingMasterTest {
    @Test
    public void test_should_park_car_to_parking_lot_with_more_left_lots() throws Exception {
        ParkingLot parkingLot1 = Helper.createParkingLot(1, 5);
        ParkingLot parkingLot2 = Helper.createParkingLot(3, 10);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1,parkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new SmarterChooser());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertThat(parkingLot2.unPark(ticket), sameInstance(car));
    }

}
