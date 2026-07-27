import java.util.Scanner;

public class LowerCaseDemo {
    static String convert(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                ch = (char) (ch + 32);
            str += ch;
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
        String text = sc.nextLine();

        String s1 = convert(text);
        String s2 = text.toLowerCase();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(compare(s1, s2));
    
        sc.close();}
}