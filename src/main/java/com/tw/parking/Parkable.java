package com.tw.parking;

public interface Parkable {
    Ticket park(Car car);

    Car unPark(Ticket ticket);

    void accept(Report report);
}
