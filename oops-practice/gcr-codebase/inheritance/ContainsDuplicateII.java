import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastSeenIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastSeenIndex.containsKey(nums[i]) && i - lastSeenIndex.get(nums[i]) <= k) {
                return true;
            }
            lastSeenIndex.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums, 3));
    }
}
