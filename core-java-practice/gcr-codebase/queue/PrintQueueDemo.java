import java.util.ArrayDeque;
import java.util.Deque;

public class PrintQueueDemo {
    private final Deque<Integer> printQueue = new ArrayDeque<>();

    public void submitJob(int jobId) {
        printQueue.addLast(jobId);
    }

    public void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
    }

    public int printNextJob() {
        if (printQueue.isEmpty()) {
            throw new RuntimeException("No jobs available");
        }
        return printQueue.removeFirst();
    }

    public static void main(String[] args) {
        PrintQueueDemo demo = new PrintQueueDemo();
        demo.submitJob(101);
        demo.submitJob(102);
        demo.submitUrgentJob(100);
        System.out.println(demo.printNextJob());
        System.out.println(demo.printNextJob());
    }
}
