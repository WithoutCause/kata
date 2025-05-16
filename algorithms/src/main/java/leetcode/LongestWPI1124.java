package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestWPI1124 {

    public static int longestWPI(int[] hours) {
        int[] prefix = new int[hours.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < hours.length; i++) {
            int score = hours[i] > 8 ? 1 : -1;
            prefix[i + 1] = prefix[i] + score;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prefix.length; i++) {
            if (stack.isEmpty() || prefix[i] < prefix[stack.peek()]) {
                stack.push(i);
            }
        }

        int maxLen = 0;
        for (int j = prefix.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && prefix[j] > prefix[stack.peek()]) {
                maxLen = Math.max(maxLen, j - stack.pop());
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        int res = longestWPI(hours);
        System.out.println(res);
    }

}
