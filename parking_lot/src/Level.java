package src;

import java.util.*;

public class Level {
    private int floor;
    private List<ParkingSpot> spots;

    Level(int floor, int numSpots) {
        this.floor = floor;
        this.spots = new ArrayList<>();
        for (int i = 0; i < numSpots; i++) {
            switch (i%3) {
                case 0 -> spots.add(new ParkingSpot(VehicleSize.BIKE, i));
                case 1 -> spots.add(new ParkingSpot(VehicleSize.SMALL, i));
                default -> spots.add(new ParkingSpot(VehicleSize.LARGE, i));
            }
        }
    }

    public void displayAvailableSpots () {
        int count = 0;
        for (ParkingSpot spot: spots) {
            if (spot.getVehicle() == null)
                count++;
        }
        System.out.println("Level " + floor + " has " + count + " spots available.");
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public int getFloor() {
        return floor;
    }
}