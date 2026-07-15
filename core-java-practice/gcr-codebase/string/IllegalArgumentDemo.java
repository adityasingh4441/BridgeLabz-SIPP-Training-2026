import java.util.Scanner;

public class IllegalArgumentDemo {
    static void generate(String s) {
        System.out.println(s.substring(5, 2));
    }

    static void handle(String s) {
        try {
            System.out.println(s.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException Handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException Handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        handle(s);
    }
}