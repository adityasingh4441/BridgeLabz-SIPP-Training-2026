import java.util.Scanner;

public class NumberFormatDemo {
    static void generate(String text) {
        System.out.println(Integer.parseInt(text));
    }

    static void handle(String text) {
        try {
            System.out.println(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException Handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException Handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handle(text);
    }
}