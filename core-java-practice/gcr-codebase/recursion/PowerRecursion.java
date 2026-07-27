import java.util.Scanner;

public class PowerRecursion {
    public static long calculatePower(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        return base * calculatePower(base, exponent - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        int base = scanner.nextInt();

        System.out.print("Enter n: ");
        int exponent = scanner.nextInt();

        System.out.println(calculatePower(base, exponent));
    
        scanner.close();}
}
