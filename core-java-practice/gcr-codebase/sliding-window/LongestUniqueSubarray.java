import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubarray {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> lastSeen = new HashMap<>();
        int start = 0, maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (lastSeen.containsKey(c)) {
                start = Math.max(start, lastSeen.get(c) + 1);
            }
            lastSeen.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
