public class FixedWindowCpuSpike {
    public int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        if (cpuLoad == null || cpuLoad.length < k || k <= 0) {
            return 0;
        }
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }
        return maxSum;
    }

    public int maximumSumSubarrayWithSizeK(int[] nums, int k) {
        return maxSubarrayOfSizeK(nums, k);
    }
}
