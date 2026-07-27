import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLogsDemo {
    static class LogEntry {
        int timestamp;
        String source;

        LogEntry(int timestamp, String source) {
            this.timestamp = timestamp;
            this.source = source;
        }
    }

    public static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
                sources.get(a[0]).get(a[1]).timestamp - sources.get(b[0]).get(b[1]).timestamp
        );

        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0];
            int elementIdx = top[1];
            merged.add(sources.get(sourceIdx).get(elementIdx));

            if (elementIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[]{sourceIdx, elementIdx + 1});
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        List<List<LogEntry>> sources = List.of(
                List.of(new LogEntry(1, "A"), new LogEntry(4, "A")),
                List.of(new LogEntry(2, "B"), new LogEntry(3, "B"))
        );
        System.out.println(mergeKSortedLogs(sources).stream().map(entry -> entry.timestamp).toList());
    }
}
