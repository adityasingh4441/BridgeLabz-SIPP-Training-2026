public class VehicleRentalSystem {
    static abstract class Vehicle {
        private String vehicleNumber;
        private String vehicleType;

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        abstract double calculateRentalCost(int days);

        void displayVehicleDetails() {
            System.out.println("Vehicle Number: " + vehicleNumber);
            System.out.println("Vehicle Type: " + vehicleType);
        }
    }

    static class Car extends Vehicle {
        private double dailyRate;

        public double getDailyRate() {
            return dailyRate;
        }

        public void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

        @Override
        double calculateRentalCost(int days) {
            return days * dailyRate;
        }
    }

    static class Bike extends Vehicle {
        private double dailyRate;

        public double getDailyRate() {
            return dailyRate;
        }

        public void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

        @Override
        double calculateRentalCost(int days) {
            return days * dailyRate;
        }
    }

    static class Truck extends Vehicle {
        private double dailyRate;
        private double loadingCharge;

        public double getDailyRate() {
            return dailyRate;
        }

        public void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

        public double getLoadingCharge() {
            return loadingCharge;
        }

        public void setLoadingCharge(double loadingCharge) {
            this.loadingCharge = loadingCharge;
        }

        @Override
        double calculateRentalCost(int days) {
            return (days * dailyRate) + loadingCharge;
        }
    }

    public static void main(String[] args) {
        int days = 3;

        Car car = new Car();
        car.setVehicleNumber("CAR101");
        car.setVehicleType("Car");
        car.setDailyRate(1200);

        Bike bike = new Bike();
        bike.setVehicleNumber("BIKE201");
        bike.setVehicleType("Bike");
        bike.setDailyRate(400);

        Truck truck = new Truck();
        truck.setVehicleNumber("TRUCK301");
        truck.setVehicleType("Truck");
        truck.setDailyRate(2500);
        truck.setLoadingCharge(1000);

        Vehicle[] vehicles = {car, bike, truck};
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails();
            System.out.println("Rental Cost: " + vehicle.calculateRentalCost(days));
        }
    }
}
