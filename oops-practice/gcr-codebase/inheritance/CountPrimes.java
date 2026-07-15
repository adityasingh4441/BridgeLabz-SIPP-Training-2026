import java.util.Arrays;

public class CountPrimes {
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int number = 2; number * number < n; number++) {
            if (isPrime[number]) {
                for (int multiple = number * number; multiple < n; multiple += number) {
                    isPrime[multiple] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
