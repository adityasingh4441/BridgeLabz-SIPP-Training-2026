import java.util.PriorityQueue;

public class PatientTriageSystem {
    private final PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);

    public void admitPatient(Patient patient) {
        triageQueue.offer(patient);
    }

    public Patient callNextPatient() {
        if (triageQueue.isEmpty()) {
            throw new RuntimeException("No patients waiting");
        }
        return triageQueue.poll();
    }

    public static class Patient {
        int priority;
        String name;

        public Patient(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " (priority " + priority + ")";
        }
    }

    public static void main(String[] args) {
        PatientTriageSystem system = new PatientTriageSystem();
        system.admitPatient(new Patient(5, "Alice"));
        system.admitPatient(new Patient(1, "Bob"));
        system.admitPatient(new Patient(3, "Cara"));
        System.out.println(system.callNextPatient());
        System.out.println(system.callNextPatient());
    }
}
