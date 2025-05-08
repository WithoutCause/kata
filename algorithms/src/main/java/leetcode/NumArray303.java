package leetcode;

public class NumArray303 {

    private int[] nums;

    public NumArray303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right ; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray303 numArray = new NumArray303(nums);
        int i = numArray.sumRange(0, 2);
        System.out.println(i);
        i = numArray.sumRange(2, 5);
        System.out.println(i);
        i = numArray.sumRange(0, 5);
        System.out.println(i);

    }

}
