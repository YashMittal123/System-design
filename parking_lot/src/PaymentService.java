package src;

import java.time.Duration;
import java.time.LocalDateTime;

public class PaymentService {
    public static double calculateFee (LocalDateTime entryTime, LocalDateTime exitTime, Vehicle v) {
        long hours = Math.max(1, Duration.between(entryTime, exitTime).toHours());
        switch(v.getVehicleSize()) {
            case VehicleSize.BIKE -> {
                return hours * 10;
            }
            case VehicleSize.SMALL -> {
                return hours * 20;
            }
            case VehicleSize.LARGE -> {
                return hours * 50;
            }
            default -> {
                return hours * 10;
            }
        }
    }
}