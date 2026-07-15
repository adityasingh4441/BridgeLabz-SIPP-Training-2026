import java.util.Scanner;

class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleanedText.length() - 1;

        while (left < right) {
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a palindrome");
        } else {
            System.out.println(text + " is not a palindrome");
        }
    }
}

public class PalindromeCheckerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker(text);
        checker.displayResult();
    }
}
