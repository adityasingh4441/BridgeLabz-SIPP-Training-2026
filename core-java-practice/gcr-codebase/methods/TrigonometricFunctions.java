import java.util.Scanner;

public class TrigonometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);

        return new double[] {sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();

        double[] result = calculateTrigonometricFunctions(angleInDegrees);

        System.out.println("Sine is " + result[0]);
        System.out.println("Cosine is " + result[1]);
        System.out.println("Tangent is " + result[2]);
    }
}
