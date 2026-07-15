import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortCharactersByFrequency {
    public static String frequencySort(String text) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char character : text.toCharArray()) {
            frequency.put(character, frequency.getOrDefault(character, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(frequency.keySet());
        characters.sort((first, second) -> frequency.get(second) - frequency.get(first));

        StringBuilder result = new StringBuilder();
        for (char character : characters) {
            int count = frequency.get(character);
            for (int i = 0; i < count; i++) {
                result.append(character);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        System.out.println(frequencySort(text));
    }
}
