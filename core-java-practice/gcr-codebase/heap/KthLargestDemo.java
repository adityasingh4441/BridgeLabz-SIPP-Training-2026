import java.util.PriorityQueue;

public class KthLargestDemo {
    public static int findKthLargest(int[] scores, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] scores = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(scores, 2));
    }
}
