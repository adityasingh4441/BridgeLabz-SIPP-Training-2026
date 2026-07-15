public class SmartHomeDevicesDemo {
    static class Device {
        private String deviceId;
        private String status;

        Device(String deviceId, String status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        void displayStatus() {
            System.out.println("Device ID: " + deviceId);
            System.out.println("Status: " + status);
        }
    }

    static class Thermostat extends Device {
        private double temperatureSetting;

        Thermostat(String deviceId, String status, double temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        @Override
        void displayStatus() {
            super.displayStatus();
            System.out.println("Temperature Setting: " + temperatureSetting);
        }
    }

    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("TH101", "ON", 24.5);
        thermostat.displayStatus();
    }
}
