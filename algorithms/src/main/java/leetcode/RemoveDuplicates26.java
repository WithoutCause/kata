package main.java.leetcode;

import java.util.Arrays;

/**
 * LeetCode 26
 */
public class RemoveDuplicates26 {

    /**
     * 对一个有序的升序数组 ，删除重复元素，并返回数组长度 n，在元数组上完成 。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        // 定义一个长度的变量 count
        int count = 0;
        // 相邻两个元素比较
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int n = removeDuplicates(nums);
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }

}
