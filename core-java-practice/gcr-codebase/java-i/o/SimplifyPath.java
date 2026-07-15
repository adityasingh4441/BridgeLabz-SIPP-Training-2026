import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (String directory : stack) {
            result.append("/").append(directory);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter path: ");
        String path = scanner.nextLine();

        System.out.println(simplifyPath(path));
    }
}
