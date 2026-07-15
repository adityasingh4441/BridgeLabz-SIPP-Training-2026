import java.util.Scanner;

public class StringPermutationsRecursion {
    public static void generatePermutations(String text, String answer) {
        if (text.length() == 0) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);
            String remaining = text.substring(0, i) + text.substring(i + 1);
            generatePermutations(remaining, answer + currentCharacter);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        generatePermutations(text, "");
    }
}
