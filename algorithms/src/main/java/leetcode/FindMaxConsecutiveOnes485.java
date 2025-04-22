package main.java.leetcode;


public class FindMaxConsecutiveOnes485 {

    /**
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int lastZeroIndex = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lastZeroIndex = i;
            } else {
                count = Math.max(i - lastZeroIndex, count);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }

}
