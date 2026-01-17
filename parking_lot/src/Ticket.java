package src;

import java.time.LocalDateTime;

public class Ticket {
    private final ParkingSpot spot;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amount;

    public Ticket(Vehicle v, ParkingSpot spot) {
        this.vehicle = v;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public void closeTicket () {
        this.exitTime = LocalDateTime.now();
        this.amount = PaymentService.calculateFee(entryTime, exitTime, vehicle);
    }

    public ParkingSpot getSpot() {
        return this.spot;
    }

    public double getAmount() {
        return this.amount;
    }
}