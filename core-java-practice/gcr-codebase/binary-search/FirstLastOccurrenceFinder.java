public class FirstLastOccurrenceFinder {
    public int[] searchRange(int[] nums, int target) {
        int first = findBoundary(nums, target, true);
        int last = findBoundary(nums, target, false);
        return new int[]{first, last};
    }

    private int findBoundary(int[] nums, int target, boolean findFirst) {
        int left = 0;
        int right = nums.length - 1;
        int boundary = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                boundary = mid;
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return boundary;
    }
}
