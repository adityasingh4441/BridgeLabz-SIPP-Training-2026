import java.util.Scanner;

public class FibonacciRecursion {
    public static int findFibonacci(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }

        return findFibonacci(number - 1) + findFibonacci(number - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int number = scanner.nextInt();

        System.out.println(findFibonacci(number));
    
        scanner.close();}
}
