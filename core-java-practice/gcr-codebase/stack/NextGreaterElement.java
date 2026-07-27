import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static int[] nextGreaterValues(int[] visitors) {
        int n = visitors.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                answer[stack.pop()] = visitors[i];
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] visitors = {4, 2, 7, 1, 5};
        System.out.println(Arrays.toString(nextGreaterValues(visitors)));
    }
}
