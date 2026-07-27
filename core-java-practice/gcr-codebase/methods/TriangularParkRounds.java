import java.util.Scanner;

public class TriangularParkRounds {
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first side in meters: ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter second side in meters: ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter third side in meters: ");
        double side3 = scanner.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);

        System.out.println("The athlete must complete " + rounds + " rounds to run 5 km");
    
        scanner.close();}
}
