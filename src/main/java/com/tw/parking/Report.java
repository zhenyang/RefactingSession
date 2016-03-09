package com.tw.parking;

import com.google.common.base.Strings;

import java.util.List;

public class Report {
    private final int level;
    private final StringBuilder result;

    public Report(int level, StringBuilder result) {
        this.level = level;
        this.result = result;
    }

    public void visitParkingBoy(List<ParkingLot> parkingLots) {
        result.append(Strings.repeat("--", level)).append("ParkingBoy\n");
        for (ParkingLot parkingLot : parkingLots) {
            result.append(parkingLot.report(level + 1));
        }
    }

    public void visitParkingManager(List<Parkable> parkables) {
        result.append(Strings.repeat("--", level)).append("ParkingManager\n");
        for (Parkable parkable : parkables) {
            parkable.accept(new Report(level + 1, result));
        }
    }
}
