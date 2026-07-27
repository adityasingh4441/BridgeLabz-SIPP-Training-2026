import java.util.PriorityQueue;

public class EmergencyTriageSystem {
    static class Patient {
        int severity;
        String name;

        Patient(int severity, String name) {
            this.severity = severity;
            this.name = name;
        }
    }

    private final PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    public void addPatient(Patient patient) {
        triageQueue.offer(patient);
    }

    public Patient treatNext() {
        if (triageQueue.isEmpty()) {
            throw new IllegalStateException("No patients waiting");
        }
        return triageQueue.poll();
    }

    public static void main(String[] args) {
        EmergencyTriageSystem system = new EmergencyTriageSystem();
        system.addPatient(new Patient(3, "Alice"));
        system.addPatient(new Patient(8, "Bob"));
        system.addPatient(new Patient(5, "Cara"));
        System.out.println(system.treatNext().name);
        System.out.println(system.treatNext().name);
    }
}
