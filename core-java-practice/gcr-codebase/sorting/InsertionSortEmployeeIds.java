public class InsertionSortEmployeeIds {
    public static void main(String[] args) {
        int[] employeeIds = {105, 101, 104, 103, 102};
        insertionSort(employeeIds);
        System.out.println("Sorted employee IDs:");
        printArray(employeeIds);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
