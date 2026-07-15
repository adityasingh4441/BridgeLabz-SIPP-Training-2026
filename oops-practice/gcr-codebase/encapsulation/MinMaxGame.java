public class MinMaxGame {
    public static int minMaxGame(int[] nums) {
        int length = nums.length;

        while (length > 1) {
            int[] next = new int[length / 2];

            for (int i = 0; i < next.length; i++) {
                if (i % 2 == 0) {
                    next[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    next[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }

            nums = next;
            length = nums.length;
        }

        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        System.out.println(minMaxGame(nums));
    }
}
