import java.util.Scanner;

public class MultiplicationTableFromSixToNine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] multiplicationResult = new int[4];

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        input.close();
    }
}
