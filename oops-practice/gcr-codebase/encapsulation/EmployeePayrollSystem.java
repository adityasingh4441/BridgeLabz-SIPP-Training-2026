public class EmployeePayrollSystem {
    static abstract class Employee {
        private int employeeId;
        private String employeeName;

        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        abstract double calculateSalary();

        void displayEmployeeInfo() {
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Employee Name: " + employeeName);
        }
    }

    static class FullTimeEmployee extends Employee {
        private double monthlySalary;

        public double getMonthlySalary() {
            return monthlySalary;
        }

        public void setMonthlySalary(double monthlySalary) {
            this.monthlySalary = monthlySalary;
        }

        @Override
        double calculateSalary() {
            return monthlySalary;
        }
    }

    static class PartTimeEmployee extends Employee {
        private int hoursWorked;
        private double hourlyRate;

        public int getHoursWorked() {
            return hoursWorked;
        }

        public void setHoursWorked(int hoursWorked) {
            this.hoursWorked = hoursWorked;
        }

        public double getHourlyRate() {
            return hourlyRate;
        }

        public void setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
        }

        @Override
        double calculateSalary() {
            return hoursWorked * hourlyRate;
        }
    }

    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.setEmployeeId(101);
        fullTimeEmployee.setEmployeeName("Rahul");
        fullTimeEmployee.setMonthlySalary(50000);

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setEmployeeId(102);
        partTimeEmployee.setEmployeeName("Priya");
        partTimeEmployee.setHoursWorked(80);
        partTimeEmployee.setHourlyRate(300);

        fullTimeEmployee.displayEmployeeInfo();
        System.out.println("Salary: " + fullTimeEmployee.calculateSalary());

        partTimeEmployee.displayEmployeeInfo();
        System.out.println("Salary: " + partTimeEmployee.calculateSalary());
    }
}
