interface HeartRateMonitor {
    int readHeartRate(String patientId);

    default void displayHealthTips() {
        System.out.println("Maintain a healthy heart rate through regular exercise");
    }
}

interface TemperatureMonitor {
    double readTemperature(String patientId);

    default void displayHealthTips() {
        System.out.println("Maintain normal body temperature and stay hydrated");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("PAT[0-9]{3}");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    public int readHeartRate(String patientId) {
        int number = Integer.parseInt(patientId.substring(3));
        return 65 + number % 30;
    }

    public double readTemperature(String patientId) {
        int number = Integer.parseInt(patientId.substring(3));
        return 97.0 + number % 3;
    }

    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void generatePatientReport(String name, String patientId) {
        if (!TemperatureMonitor.isPatientIdValid(patientId)) {
            System.out.println(name + " has invalid patient ID");
            return;
        }

        int heartRate = readHeartRate(patientId);
        double temperature = readTemperature(patientId);
        String status = heartRate >= 60 && heartRate <= 100 && temperature >= 97.0 && temperature <= 99.0 ? "Normal" : "Needs attention";

        System.out.println(name + " | ID: " + patientId + " | Heart Rate: " + heartRate + " bpm | Temperature: " + temperature + " F | Status: " + status);
    }
}

public class HealthMonitoringSystemDemo {
    public static void main(String[] args) {
        String[] patientNames = {"Riya", "Arjun", "Neha"};
        String[] patientIds = {"PAT101", "PAT205", "P301"};
        HealthMonitoringSystem system = new HealthMonitoringSystem();

        system.displayHealthTips();
        System.out.println("Final Health Report");

        for (int i = 0; i < patientNames.length; i++) {
            system.generatePatientReport(patientNames[i], patientIds[i]);
        }
    }
}
