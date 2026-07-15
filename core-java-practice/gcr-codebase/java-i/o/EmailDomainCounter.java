import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmailDomainCounter {
    public static void countDomains(String fileName) {
        Map<String, Integer> domainCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String email;

            while ((email = reader.readLine()) != null) {
                int atIndex = email.indexOf('@');

                if (atIndex != -1 && atIndex < email.length() - 1) {
                    String domain = email.substring(atIndex + 1);
                    domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException exception) {
            System.out.println("Error reading email file");
        }
    }

    public static void main(String[] args) {
        countDomains("emails.txt");
    }
}
