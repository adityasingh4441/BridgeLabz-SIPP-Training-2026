import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletLoadBalancing {
    public List<List<Integer>> findTriplets(int[] jobs, int target) {
        Arrays.sort(jobs);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < jobs.length - 2; i++) {
            if (i > 0 && jobs[i] == jobs[i - 1]) continue;
            int left = i + 1, right = jobs.length - 1;
            while (left < right) {
                int sum = jobs[i] + jobs[left] + jobs[right];
                if (sum == target) {
                    result.add(Arrays.asList(jobs[i], jobs[left], jobs[right]));
                    while (left < right && jobs[left] == jobs[left + 1]) left++;
                    while (left < right && jobs[right] == jobs[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
