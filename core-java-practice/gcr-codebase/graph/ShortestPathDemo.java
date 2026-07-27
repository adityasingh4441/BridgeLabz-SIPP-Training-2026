import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathDemo {
    public static List<Integer> fewestFlights(Map<Integer, List<Integer>> routes, int origin, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            if (city == destination) {
                break;
            }
            for (int next : routes.getOrDefault(city, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, city);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination)) {
            return Collections.emptyList();
        }

        LinkedList<Integer> path = new LinkedList<>();
        Integer node = destination;
        while (node != null) {
            path.addFirst(node);
            node = parent.get(node);
        }
        return path;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> routes = new HashMap<>();
        routes.put(1, List.of(2, 3));
        routes.put(2, List.of(4));
        routes.put(3, List.of(4));
        routes.put(4, List.of());
        System.out.println(fewestFlights(routes, 1, 4));
    }
}
