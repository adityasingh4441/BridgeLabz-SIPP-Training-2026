public class HospitalPatientManagementSystem {
    static abstract class Patient {
        private int patientId;
        private String name;
        private int age;

        public int getPatientId() {
            return patientId;
        }

        public void setPatientId(int patientId) {
            this.patientId = patientId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        abstract double calculateBill();

        void displayPatientDetails() {
            System.out.println("Patient ID: " + patientId);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }

    static class InPatient extends Patient {
        private double roomCharges;
        private double treatmentCharges;

        public double getRoomCharges() {
            return roomCharges;
        }

        public void setRoomCharges(double roomCharges) {
            this.roomCharges = roomCharges;
        }

        public double getTreatmentCharges() {
            return treatmentCharges;
        }

        public void setTreatmentCharges(double treatmentCharges) {
            this.treatmentCharges = treatmentCharges;
        }

        @Override
        double calculateBill() {
            return roomCharges + treatmentCharges;
        }
    }

    static class OutPatient extends Patient {
        private double consultationFees;
        private double treatmentCharges;

        public double getConsultationFees() {
            return consultationFees;
        }

        public void setConsultationFees(double consultationFees) {
            this.consultationFees = consultationFees;
        }

        public double getTreatmentCharges() {
            return treatmentCharges;
        }

        public void setTreatmentCharges(double treatmentCharges) {
            this.treatmentCharges = treatmentCharges;
        }

        @Override
        double calculateBill() {
            return consultationFees + treatmentCharges;
        }
    }

    public static void main(String[] args) {
        InPatient inPatient = new InPatient();
        inPatient.setPatientId(101);
        inPatient.setName("Ravi");
        inPatient.setAge(45);
        inPatient.setRoomCharges(3000);
        inPatient.setTreatmentCharges(7000);

        OutPatient outPatient = new OutPatient();
        outPatient.setPatientId(102);
        outPatient.setName("Sita");
        outPatient.setAge(32);
        outPatient.setConsultationFees(500);
        outPatient.setTreatmentCharges(1500);

        inPatient.displayPatientDetails();
        System.out.println("Bill: " + inPatient.calculateBill());

        outPatient.displayPatientDetails();
        System.out.println("Bill: " + outPatient.calculateBill());
    }
}
