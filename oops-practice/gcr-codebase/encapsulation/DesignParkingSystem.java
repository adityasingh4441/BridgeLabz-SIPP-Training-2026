public class DesignParkingSystem {
    static class ParkingSystem {
        private int big;
        private int medium;
        private int small;

        ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1 && big > 0) {
                big--;
                return true;
            }
            if (carType == 2 && medium > 0) {
                medium--;
                return true;
            }
            if (carType == 3 && small > 0) {
                small--;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
    }
}
