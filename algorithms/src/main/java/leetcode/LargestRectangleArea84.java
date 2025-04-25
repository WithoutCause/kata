package leetcode;

import java.util.Stack;

public class LargestRectangleArea84 {

    /**
     * 暴力解法
     * @param heights
     * @return
     */
    public static int largestRectangleAreaV1(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftMinIndex = -1;
            int rightMinIndex = heights.length;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    leftMinIndex = j;
                    break;
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    rightMinIndex = j;
                    break;
                }
            }

            int rectangleArea = (rightMinIndex - leftMinIndex - 1) * heights[i];
            res = Math.max(rectangleArea, res);

        }

        return res;
    }

    public static int largestRectangleAreaV2(int[] heights) {
        int res = 0;
        // 使用单调栈
        Stack<Integer> stack = new Stack<>();
        // 将给定的原数组左右各添加一个元素0，方便处理
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int cur = stack.pop();
                int curHeight = newHeights[cur];
                int leftIndex = stack.peek();
                int curWidth = i - leftIndex - 1;
                res = Math.max(res, curWidth * curHeight);
            }

            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int largestRectangleArea = largestRectangleAreaV2(heights);
        System.out.println(largestRectangleArea);
    }

}
