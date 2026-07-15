import java.util.Scanner;

public class SubStringDemo {
    static String mySubstring(String s, int start, int end) {
        String str = "";
        for (int i = start; i < end; i++) {
            str += s.charAt(i);
        }
        return str;
    }

    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String s1 = mySubstring(text, start, end);
        String s2 = text.substring(start, end);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(compare(s1, s2));
    }
}