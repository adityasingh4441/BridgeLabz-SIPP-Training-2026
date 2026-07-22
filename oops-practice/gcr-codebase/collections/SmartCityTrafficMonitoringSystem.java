import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {
    private final Map<String, Integer> trafficMap = new HashMap<>();

    public void addOrUpdateRoadCount(String roadName, int vehicles) {
        trafficMap.put(roadName, trafficMap.getOrDefault(roadName, 0) + vehicles);
    }

    public void displayTrafficReport() {
        TreeMap<String, Integer> sortedTraffic = new TreeMap<>(trafficMap);
        System.out.println("Traffic Report (sorted by road name):");
        for (Map.Entry<String, Integer> entry : sortedTraffic.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vehicles");
        }
    }

    public void displayBusiestRoad() {
        if (trafficMap.isEmpty()) {
            System.out.println("No traffic data available.");
            return;
        }

        Map.Entry<String, Integer> busiest = null;
        for (Map.Entry<String, Integer> entry : trafficMap.entrySet()) {
            if (busiest == null || entry.getValue() > busiest.getValue()) {
                busiest = entry;
            }
        }

        System.out.println("Busiest road: " + busiest.getKey() + " with " + busiest.getValue() + " vehicles");
    }

    public void displayTotalRoads() {
        System.out.println("Total roads monitored: " + trafficMap.size());
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem system = new SmartCityTrafficMonitoringSystem();
        system.addOrUpdateRoadCount("Main Street", 120);
        system.addOrUpdateRoadCount("Park Avenue", 90);
        system.addOrUpdateRoadCount("Main Street", 40);
        system.addOrUpdateRoadCount("River Road", 70);
        system.addOrUpdateRoadCount("Park Avenue", 35);

        system.displayTrafficReport();
        system.displayBusiestRoad();
        system.displayTotalRoads();
    }
}
