package leetcode;

public class Trap42 {

    public static int trap(int[] height) {
        int left = 0;
        int leftMax = 0;
        int right =height.length - 1;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};
        int trap = trap(height);
        System.out.println(trap);
    }

}
