import java.util.Scanner;

public class MultipleCatchBlocksDemo {
    public static void printValueAtIndex(int[] numbers, int index) {
        try {
            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid index!");
        } catch (NullPointerException exception) {
            System.out.println("Array is not initialized!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size, or -1 for null array: ");
        int size = scanner.nextInt();

        int[] numbers = null;
        if (size >= 0) {
            numbers = new int[size];
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }
        }

        System.out.print("Enter index: ");
        int index = scanner.nextInt();

        printValueAtIndex(numbers, index);
    }
}
