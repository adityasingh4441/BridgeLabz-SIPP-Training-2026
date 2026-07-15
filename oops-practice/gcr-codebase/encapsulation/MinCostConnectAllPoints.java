import java.util.PriorityQueue;

public class MinCostConnectAllPoints {
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[] {0, 0});

        int totalCost = 0;
        int connectedPoints = 0;

        while (connectedPoints < n) {
            int[] current = minHeap.poll();
            int pointIndex = current[0];
            int cost = current[1];

            if (visited[pointIndex]) {
                continue;
            }

            visited[pointIndex] = true;
            totalCost += cost;
            connectedPoints++;

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int distance = Math.abs(points[pointIndex][0] - points[next][0])
                            + Math.abs(points[pointIndex][1] - points[next][1]);
                    minHeap.offer(new int[] {next, distance});
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points));
    }
}
