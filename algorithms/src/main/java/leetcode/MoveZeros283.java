package main.java.leetcode;

import java.util.Arrays;


public class MoveZeros283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * @param nums
     */
    public static void moveZeros(int[] nums) {
        // 定义一个慢指针
        int slowPointer = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不为0，将慢指针所在的位置置为 0，并且慢指针向前推进一位
            if (nums[i] != 0) {
                nums[slowPointer] = nums[i];
                slowPointer++;
            }
        }

        // 遍历完数组以后，将慢指针后面位置的数组元素全部置为 0
        for (int i = slowPointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     *
     * @param nums
     */
    public static void moveZeros2(int[] nums) {
        // 定义左右指针，初始值都为第一个元素。左指针是最后一个 0 元素，右指针是 0 元素
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[right] != 0) {
                //交换左右指针的元素
                swap(nums, left, right);
                // 左指针向前推进 1
                left++;
            }
            //向指针向前推进 1
            right++;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
