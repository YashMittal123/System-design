package src;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance(2, 2);

        Vehicle car1 = new Car("car01");
        Vehicle bike1 = new Bike("bike01");
        Vehicle car2 = new Car("car02");
        Vehicle truck1 = new Truck("truck01");

        lot.showAvailability();

        lot.parkVehicle(car1);
        lot.parkVehicle(bike1);
        lot.parkVehicle(car2);
        lot.parkVehicle(truck1);

        lot.showAvailability();

        lot.removeVehicle(car1);
        lot.removeVehicle(truck1);

        lot.showAvailability();

    }
}