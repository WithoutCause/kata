package leetcode;

public class ProductExceptSelf238 {

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        System.out.println(ints);
    }

}
