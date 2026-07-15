import java.util.Scanner;

public class ArraySubsetsRecursion {
    public static void generateSubsetsBySize(int[] array) {
        for (int size = 0; size <= array.length; size++) {
            generateSubsets(array, 0, new int[size], 0, size);
        }
    }

    public static void generateSubsets(int[] array, int index, int[] subset, int subsetIndex, int targetSize) {
        if (subsetIndex == targetSize) {
            printSubset(subset, targetSize);
            return;
        }

        if (index == array.length) {
            return;
        }

        subset[subsetIndex] = array[index];
        generateSubsets(array, index + 1, subset, subsetIndex + 1, targetSize);
        generateSubsets(array, index + 1, subset, subsetIndex, targetSize);
    }

    public static void printSubset(int[] subset, int size) {
        System.out.print("[");

        for (int i = 0; i < size; i++) {
            System.out.print(subset[i]);
            if (i < size - 1) {
                System.out.print(",");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        generateSubsetsBySize(array);
    }
}
