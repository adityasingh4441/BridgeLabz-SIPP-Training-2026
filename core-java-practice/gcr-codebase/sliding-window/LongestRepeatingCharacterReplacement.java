import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> freq = new HashMap<>();
        int start = 0, maxLen = 0, maxFreq = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freq.merge(c, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, freq.get(c));
            while (end - start + 1 - maxFreq > k) {
                char leftChar = s.charAt(start);
                freq.put(leftChar, freq.get(leftChar) - 1);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
