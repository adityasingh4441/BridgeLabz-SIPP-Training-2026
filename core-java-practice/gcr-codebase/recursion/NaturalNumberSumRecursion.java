import java.util.Scanner;

public class NaturalNumberSumRecursion {
    public static int findSum(int number) {
        if (number == 0) {
            return 0;
        }

        return number + findSum(number - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int number = scanner.nextInt();

        System.out.println(findSum(number));
    }
}
