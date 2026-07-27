import java.util.Scanner;

public class FactorialRecursion {
    public static long calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }

        return number * calculateFactorial(number - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        System.out.println(calculateFactorial(number));
    
        scanner.close();}
}
