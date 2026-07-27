import java.util.Scanner;

public class ReverseStringRecursion {
    public static String reverseString(String text) {
        if (text == null || text.length() <= 1) {
            return text;
        }

        return reverseString(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        System.out.println(reverseString(text));
    
        scanner.close();}
}
