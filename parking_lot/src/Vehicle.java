package src;

enum VehicleSize {
    BIKE, 
    SMALL, 
    LARGE
};

public abstract class Vehicle {
    String vehicleNumber;
    VehicleSize size;

    public String getVehicleNumber () {
        return vehicleNumber;
    }

    public VehicleSize getVehicleSize () {
        return size;
    }
}

class Car extends Vehicle {
    Car (String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.size = VehicleSize.SMALL;
    }
}

class Bike extends Vehicle {
    Bike (String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.size = VehicleSize.BIKE;
    }
}

class Truck extends Vehicle {
    Truck (String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.size = VehicleSize.LARGE;
    }
}