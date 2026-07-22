interface Trackable {
    void logActivity(String activity, int minutes);

    default void resetData() {
        System.out.println("Fitness data has been reset");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private String lastActivity;
    private int totalMinutes;

    public void logActivity(String activity, int minutes) {
        lastActivity = activity;
        totalMinutes += minutes;
        System.out.println("Logged activity: " + activity + " for " + minutes + " minutes");
    }

    public void generateReport() {
        System.out.println("Fitness Report");
        System.out.println("Last Activity: " + lastActivity);
        System.out.println("Total Minutes: " + totalMinutes);
    }

    public void sendAlert(String message) {
        System.out.println("Alert: " + message);
    }
}

public class FitnessTrackerDemo {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity("Running", 30);
        device.logActivity("Cycling", 45);
        device.sendAlert("Daily goal almost completed");
        device.generateReport();
        device.resetData();
        System.out.println("FitnessDevice implements multiple interfaces. A Java class cannot extend multiple classes.");
    }
}
