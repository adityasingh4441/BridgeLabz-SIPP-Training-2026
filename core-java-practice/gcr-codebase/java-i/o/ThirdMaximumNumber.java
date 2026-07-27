import java.util.Scanner;

public class ThirdMaximumNumber {
    public static int thirdMax(int[] numbers) {
        Long first = null;
        Long second = null;
        Long third = null;

        for (int number : numbers) {
            long value = number;

            if ((first != null && value == first)
                    || (second != null && value == second)
                    || (third != null && value == third)) {
                continue;
            }

            if (first == null || value > first) {
                third = second;
                second = first;
                first = value;
            } else if (second == null || value > second) {
                third = second;
                second = value;
            } else if (third == null || value > third) {
                third = value;
            }
        }

        return third == null ? first.intValue() : third.intValue();
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

        System.out.println(thirdMax(numbers));
    
        scanner.close();}
}
