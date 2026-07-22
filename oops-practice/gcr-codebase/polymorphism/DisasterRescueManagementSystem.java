public class DisasterRescueManagementSystem {
    public static void main(String[] args) {
        RescueTeam[] teams = {
                new MedicalTeam("M101", "Mumbai"),
                new FireRescueTeam("F201", "Delhi"),
                new FoodSupplyTeam("S301", "Chennai"),
                new MedicalTeam("M102", "Mumbai"),
                new FireRescueTeam("F202", "Bengaluru")
        };

        DisasterRescueManagementSystem system = new DisasterRescueManagementSystem();

        system.findTeamByLocation(teams, "Mumbai");
        system.displayTeamsByPrefix(teams, "M");
        system.countTeamsByCategory(teams);
        system.displayCategoryWithMaximumDeployments(teams);
    }

    public void findTeamByLocation(RescueTeam[] teams, String location) {
        System.out.println("Teams deployed in " + location + ":");
        for (RescueTeam team : teams) {
            if (team.getLocation().equalsIgnoreCase(location)) {
                System.out.println(team.getTeamId() + " - " + team.getClass().getSimpleName());
            }
        }
    }

    public void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        System.out.println("Teams with prefix '" + prefix + "':");
        for (RescueTeam team : teams) {
            if (team.getTeamId().startsWith(prefix)) {
                System.out.println(team.getTeamId() + " - " + team.getLocation());
            }
        }
    }

    public void countTeamsByCategory(RescueTeam[] teams) {
        int medicalCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        for (RescueTeam team : teams) {
            if (team instanceof MedicalTeam) {
                medicalCount++;
            } else if (team instanceof FireRescueTeam) {
                fireCount++;
            } else if (team instanceof FoodSupplyTeam) {
                foodCount++;
            }
        }

        System.out.println("Team counts -> Medical: " + medicalCount + ", Fire Rescue: " + fireCount + ", Food Supply: " + foodCount);
    }

    public void displayCategoryWithMaximumDeployments(RescueTeam[] teams) {
        int medicalCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        for (RescueTeam team : teams) {
            if (team instanceof MedicalTeam) {
                medicalCount++;
            } else if (team instanceof FireRescueTeam) {
                fireCount++;
            } else if (team instanceof FoodSupplyTeam) {
                foodCount++;
            }
        }

        String category = "MedicalTeam";
        int max = medicalCount;

        if (fireCount > max) {
            category = "FireRescueTeam";
            max = fireCount;
        }
        if (foodCount > max) {
            category = "FoodSupplyTeam";
        }

        System.out.println("Category with maximum deployments: " + category);
    }
}

abstract class RescueTeam {
    protected String teamId;
    protected String location;

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public abstract void performDuty();

    public String getTeamId() {
        return teamId;
    }

    public String getLocation() {
        return location;
    }
}

class MedicalTeam extends RescueTeam {
    public MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Medical team " + teamId + " provides emergency treatment.");
    }
}

class FireRescueTeam extends RescueTeam {
    public FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Fire rescue team " + teamId + " extinguishes fire and saves lives.");
    }
}

class FoodSupplyTeam extends RescueTeam {
    public FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Food supply team " + teamId + " distributes relief food.");
    }
}
