import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }

        return bits;
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        System.out.println(Arrays.toString(solution.countBits(5)));
    }
}
