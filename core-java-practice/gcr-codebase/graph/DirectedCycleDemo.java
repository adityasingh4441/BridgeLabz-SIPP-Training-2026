import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedCycleDemo {
    public static boolean hasDirectedCycle(Map<Integer, List<Integer>> graph, int n) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for (int node = 0; node < n; node++) {
            if (dfsCycleDetect(graph, node, visited, visiting)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfsCycleDetect(Map<Integer, List<Integer>> graph, int node,
                                         Set<Integer> visited, Set<Integer> visiting) {
        visited.add(node);
        visiting.add(node);
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor) && dfsCycleDetect(graph, neighbor, visited, visiting)) {
                return true;
            }
            if (visiting.contains(neighbor)) {
                return true;
            }
        }
        visiting.remove(node);
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(1));
        graph.put(1, List.of(2));
        graph.put(2, List.of(0));
        System.out.println(hasDirectedCycle(graph, 3));
    }
}
