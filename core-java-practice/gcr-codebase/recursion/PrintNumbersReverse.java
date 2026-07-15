import java.util.Scanner;

public class PrintNumbersReverse {
    public static void printNumbers(int number) {
        if (number == 0) {
            return;
        }

        System.out.print(number + " ");
        printNumbers(number - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int number = scanner.nextInt();

        printNumbers(number);
    }
}
