package src;

public class ParkingSpot {
    private Vehicle vehicle;
    private final VehicleSize spotSize;
    private final int spotNumber;

    ParkingSpot(VehicleSize spotSize, int spotNumber) {
        vehicle = null;
        this.spotSize = spotSize;
        this.spotNumber = spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canAccommodate(Vehicle v) {
        if (!isAvailable()) return false;

        return spotSize.ordinal() >= v.getVehicleSize().ordinal();
    }

    public Ticket parkVehicle(Vehicle v) {
        vehicle = v;
        Ticket ticket = new Ticket(v, this);
        return ticket;
    }

    public void removeVehicle() {
        vehicle = null;
    }
}