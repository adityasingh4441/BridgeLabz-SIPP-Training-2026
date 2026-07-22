interface LuggageScanner {
    boolean scanLuggage(double weight);

    default void displaySecurityGuidelines() {
        System.out.println("Luggage must not contain restricted items and must be within allowed weight");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passport must be valid and match passenger records");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z][0-9]{7}");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    public boolean scanLuggage(double weight) {
        return weight > 0 && weight <= 25;
    }

    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public void checkPassenger(String name, String passportNo, double luggageWeight) {
        if (verifyPassport(passportNo) && scanLuggage(luggageWeight)) {
            System.out.println(name + " can board the flight");
        } else {
            System.out.println(name + " cannot board the flight");
        }
    }
}

public class AirportSecuritySystemDemo {
    public static void main(String[] args) {
        String[] passengerNames = {"Aarav", "Meera", "Kabir"};
        String[] passportNumbers = {"A1234567", "B7654321", "12345678"};
        double[] luggageWeights = {18.5, 31.0, 20.0};
        AirportSecuritySystem system = new AirportSecuritySystem();

        system.displaySecurityGuidelines();

        for (int i = 0; i < passengerNames.length; i++) {
            system.checkPassenger(passengerNames[i], passportNumbers[i], luggageWeights[i]);
        }
    }
}
