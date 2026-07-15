import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int employeeId;
    private final String name;
    private final String department;
    private final double salary;

    Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeSkillAssignment {
    public static void serializeEmployee(Employee employee, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(employee);
        } catch (IOException exception) {
            System.out.println("Error saving employee information");
        }
    }

    public static Employee deserializeEmployee(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Employee) inputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Error reading employee information");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(employeeId, name, department, salary);
        serializeEmployee(employee, "employee.ser");

        Employee recoveredEmployee = deserializeEmployee("employee.ser");
        if (recoveredEmployee != null) {
            System.out.println("Recovered employee information:");
            recoveredEmployee.display();
        }
    }
}
