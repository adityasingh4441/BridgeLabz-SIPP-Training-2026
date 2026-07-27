import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BalancedBrackets {
    public static boolean isValidConfig(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchFor = new HashMap<>();
        matchFor.put(')', '(');
        matchFor.put(']', '[');
        matchFor.put('}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != matchFor.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidConfig("({[]})"));
        System.out.println(isValidConfig("([)]"));
        System.out.println(isValidConfig("("));
    }
}
