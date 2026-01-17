package src;

import java.util.*;

public class ParkingLot {
    public static ParkingLot instance;
    private final List<Level> levels;
    private Map<String, Ticket> activeTickets;

    ParkingLot(int numLevels, int numSpots) {
        this.levels = new ArrayList<>();
        for (int i = 0; i < numLevels; i++) {
            levels.add(new Level(i, numSpots));
        }
    }

    public static ParkingLot getInstance(int numLevels, int numSpots) {
        if (instance == null) {
            instance = new ParkingLot(numLevels, numSpots);
        }
        return instance;
    }

    public void showAvailability () {
        for (Level level: levels) {
            level.displayAvailableSpots();
        }
    }

    public void parkVehicle (Vehicle vehicle) {
        for (Level level: levels) {
            for (ParkingSpot spot: level.getSpots()) {
                if (spot.canAccommodate(vehicle)) {
                    Ticket ticket = spot.parkVehicle(vehicle);
                    if (activeTickets == null) activeTickets = new HashMap<>();
                    activeTickets.put(vehicle.getVehicleNumber(), ticket);
                    System.out.println("Vehicle "+ vehicle.getVehicleNumber() + " parked on " + level.getFloor() + "th floor and spot " + spot.getSpotNumber());
                    return;
                }
            }
        }

        System.out.println("No available spots");
    }

    public void removeVehicle (Vehicle v) {
        Ticket ticket = activeTickets.remove(v.getVehicleNumber());
        if (ticket != null) {
            ParkingSpot spot = ticket.getSpot();
            spot.removeVehicle();
            ticket.closeTicket();
            System.out.println("Removing vehicle: " + v.getVehicleNumber() + " from spot: " + spot.getSpotNumber() + " with Fee: " + ticket.getAmount());
            return;
        }

        System.out.println("No vehicle with given number: " + v.getVehicleNumber() + " parked in the lot");
    }
}