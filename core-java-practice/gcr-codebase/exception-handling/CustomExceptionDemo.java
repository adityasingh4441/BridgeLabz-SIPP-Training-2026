import java.util.Scanner;

public class CustomExceptionDemo {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        try {
            validateAge(age);
            System.out.println("Access granted!");
        } catch (InvalidAgeException exception) {
            System.out.println(exception.getMessage());
        }
    
        scanner.close();}
}
