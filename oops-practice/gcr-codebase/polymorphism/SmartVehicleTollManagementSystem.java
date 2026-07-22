public class SmartVehicleTollManagementSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("KA01AB1234", "Rahul"),
                new Bus("KA05CD5678", "Meera"),
                new Truck("KA07EF9012", "Arjun"),
                new Car("KA09GH3456", "Neha"),
                new Bus("KA11IJ7890", "Kiran")
        };

        SmartVehicleTollManagementSystem system = new SmartVehicleTollManagementSystem();

        System.out.println("Total revenue collected: " + system.calculateTotalRevenue(vehicles));
        system.searchVehicle(vehicles, "KA07EF9012");
        system.displayVehicleWithHighestToll(vehicles);
        system.countVehiclesByType(vehicles);
    }

    public double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateToll();
        }
        return total;
    }

    public void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                System.out.println("Vehicle found: " + vehicle.getVehicleNumber() + " owned by " + vehicle.getOwnerName());
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public void displayVehicleWithHighestToll(Vehicle[] vehicles) {
        Vehicle highest = vehicles[0];
        for (Vehicle vehicle : vehicles) {
            if (vehicle.calculateToll() > highest.calculateToll()) {
                highest = vehicle;
            }
        }
        System.out.println("Highest toll paid by: " + highest.getVehicleNumber() + " (" + highest.getClass().getSimpleName() + ")");
    }

    public void countVehiclesByType(Vehicle[] vehicles) {
        int carCount = 0;
        int busCount = 0;
        int truckCount = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                carCount++;
            } else if (vehicle instanceof Bus) {
                busCount++;
            } else if (vehicle instanceof Truck) {
                truckCount++;
            }
        }

        System.out.println("Vehicle counts -> Car: " + carCount + ", Bus: " + busCount + ", Truck: " + truckCount);
    }
}

abstract class Vehicle {
    protected String vehicleNumber;
    protected String ownerName;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public abstract double calculateToll();

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }
}

class Car extends Vehicle {
    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 80.0;
    }
}

class Bus extends Vehicle {
    public Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 150.0;
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 220.0;
    }
}
