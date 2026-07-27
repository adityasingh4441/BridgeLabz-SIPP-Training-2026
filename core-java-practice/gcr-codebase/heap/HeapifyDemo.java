import java.util.Arrays;

public class HeapifyDemo {
    public static void buildHeap(int[] priorities) {
        int n = priorities.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(priorities, i, n);
        }
    }

    private static void siftDown(int[] arr, int i, int size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            siftDown(arr, smallest, size);
        }
    }

    public static void main(String[] args) {
        int[] priorities = {4, 10, 3, 5, 1};
        buildHeap(priorities);
        System.out.println(Arrays.toString(priorities));
    }
}
