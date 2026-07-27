import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestDemo {
    public static List<Integer> topKLargest(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] transactions = {4, 7, 1, 3, 8, 2};
        System.out.println(topKLargest(transactions, 3));
    }
}
