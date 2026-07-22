import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SpaceMissionCrewManagementSystem {
    private final Map<String, List<Astronaut>> missionCrewMap = new HashMap<>();

    public void addMission(String missionName) {
        missionCrewMap.putIfAbsent(missionName, new ArrayList<>());
    }

    public boolean assignAstronaut(String missionName, Astronaut astronaut) {
        addMission(missionName);
        List<Astronaut> crew = missionCrewMap.get(missionName);
        HashSet<String> assignedIds = new HashSet<>();

        for (Astronaut member : crew) {
            assignedIds.add(member.getAstronautId());
        }

        if (assignedIds.contains(astronaut.getAstronautId())) {
            System.out.println("Astronaut " + astronaut.getName() + " is already assigned to mission " + missionName);
            return false;
        }

        crew.add(astronaut);
        return true;
    }

    public void displayMissions() {
        for (Map.Entry<String, List<Astronaut>> entry : missionCrewMap.entrySet()) {
            System.out.println("Mission: " + entry.getKey());
            for (Astronaut astronaut : entry.getValue()) {
                System.out.println(" - " + astronaut.getAstronautId() + " | " + astronaut.getName() + " | " + astronaut.getSpecialization());
            }
            System.out.println("Total astronauts: " + entry.getValue().size());
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem system = new SpaceMissionCrewManagementSystem();

        system.addMission("Artemis-1");
        system.addMission("Mars-2026");

        system.assignAstronaut("Artemis-1", new Astronaut("A101", "Neil", "Pilot"));
        system.assignAstronaut("Artemis-1", new Astronaut("A102", "Rosa", "Engineer"));
        system.assignAstronaut("Artemis-1", new Astronaut("A101", "Neil", "Pilot"));
        system.assignAstronaut("Mars-2026", new Astronaut("A103", "Mina", "Scientist"));
        system.assignAstronaut("Mars-2026", new Astronaut("A102", "Rosa", "Engineer"));

        system.displayMissions();
    }
}

class Astronaut {
    private final String astronautId;
    private final String name;
    private final String specialization;

    public Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    public String getAstronautId() {
        return astronautId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}
