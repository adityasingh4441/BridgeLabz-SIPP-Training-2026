import java.util.Scanner;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter index: ");
        int index = scanner.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        try {
            int value = numbers[index];

            try {
                int result = value / divisor;
                System.out.println("Division result: " + result);
            } catch (ArithmeticException exception) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid array index!");
        }
    
        scanner.close();}
}
