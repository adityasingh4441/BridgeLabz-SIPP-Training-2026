import java.util.Scanner;

public class StringIndexDemo {
    static void generate(String s) {
        System.out.println(s.charAt(s.length()));
    }

    static void handle(String s) {
        try {
            System.out.println(s.charAt(s.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException Handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        handle(s);
    
        sc.close();}
}