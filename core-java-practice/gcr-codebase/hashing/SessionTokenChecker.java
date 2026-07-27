import java.util.HashSet;
import java.util.Set;

public class SessionTokenChecker {
    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens = {"abc123", "def456", "abc123", "ghi789"};
        System.out.println(hasDuplicateToken(tokens));
    }
}
