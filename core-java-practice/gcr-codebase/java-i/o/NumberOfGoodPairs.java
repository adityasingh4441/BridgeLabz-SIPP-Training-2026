import java.util.Scanner;

public class NumberOfGoodPairs {
    public static int numIdenticalPairs(int[] numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(numIdenticalPairs(numbers));
    }
}
