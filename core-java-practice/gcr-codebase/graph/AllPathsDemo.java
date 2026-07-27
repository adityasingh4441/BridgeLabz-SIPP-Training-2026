import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllPathsDemo {
    public static void allRoutes(Map<Integer, List<Integer>> roads, int current, int target,
                                List<Integer> path, Set<Integer> visited, List<List<Integer>> allRoutes) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    allRoutes(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> roads = new HashMap<>();
        roads.put(1, List.of(2, 3));
        roads.put(2, List.of(4));
        roads.put(3, List.of(4));
        roads.put(4, List.of());
        List<List<Integer>> routes = new ArrayList<>();
        allRoutes(roads, 1, 4, new ArrayList<>(), new HashSet<>(), routes);
        System.out.println(routes);
    }
}
