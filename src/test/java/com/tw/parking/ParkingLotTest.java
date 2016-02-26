package com.tw.parking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1);
    }

    @Test
    public void should_park_car() throws Exception {
        Ticket ticket = parkingLot.park(new Car());
        assertThat(ticket, is(notNullValue()));
    }

    @Test
    public void should_not_park_car_when_lot_is_full() throws Exception {
        parkingLot.park(new Car());
        Ticket ticket = parkingLot.park(new Car());
        assertThat(ticket, is(nullValue()));
    }

    @Test
    public void should_unpark_car() throws Exception {
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car unParkCar = parkingLot.unPark(ticket);
        assertThat(car, sameInstance(unParkCar));
    }

    @Test
    public void should_not_unpark_car_when_ticket_invalid() throws Exception {
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car unParkCar = parkingLot.unPark(new Ticket(new Car()));
        assertThat(unParkCar, is(nullValue()));
    }

    @Test
    public void should_park_car_multiple_times() throws Exception {
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car unParkCar = parkingLot.unPark(ticket);

        Car anotherCar = new Car();
        Ticket ticket1 = parkingLot.park(anotherCar);
        Car unParkedAnotherCar = parkingLot.unPark(ticket1);
        assertThat(unParkedAnotherCar, sameInstance(anotherCar));
    }
}
