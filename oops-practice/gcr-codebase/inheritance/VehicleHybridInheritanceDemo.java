public class VehicleHybridInheritanceDemo {
    interface Refuelable {
        void refuel();
    }

    static class Vehicle {
        private int maxSpeed;
        private String model;

        Vehicle(int maxSpeed, String model) {
            this.maxSpeed = maxSpeed;
            this.model = model;
        }

        void displayVehicle() {
            System.out.println("Model: " + model);
            System.out.println("Max Speed: " + maxSpeed);
        }
    }

    static class ElectricVehicle extends Vehicle {
        ElectricVehicle(int maxSpeed, String model) {
            super(maxSpeed, model);
        }

        void charge() {
            System.out.println("Electric vehicle is charging");
        }
    }

    static class PetrolVehicle extends Vehicle implements Refuelable {
        PetrolVehicle(int maxSpeed, String model) {
            super(maxSpeed, model);
        }

        @Override
        public void refuel() {
            System.out.println("Petrol vehicle is refueling");
        }
    }

    public static void main(String[] args) {
        ElectricVehicle electricVehicle = new ElectricVehicle(180, "Tesla Model 3");
        PetrolVehicle petrolVehicle = new PetrolVehicle(160, "Honda City");

        electricVehicle.displayVehicle();
        electricVehicle.charge();

        petrolVehicle.displayVehicle();
        petrolVehicle.refuel();
    }
}
