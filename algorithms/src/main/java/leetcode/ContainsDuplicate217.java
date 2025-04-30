package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length < 2){
            return false;
        }
        int num_min = nums[0],num_max = nums[0];

        for(int i = 1;i < nums.length;i++){
            if(nums[i] < num_min){
                num_min = nums[i];
                continue;
            }
            if(nums[i] > num_max){
                num_max = nums[i];
                continue;
            }

            for(int j=0 ; j < i;j++){
                if(nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicateV2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 1};
        //boolean b = containsDuplicate(nums);
        //System.out.println(b);

        int[] nums = new int[10000];
        nums[0] = 5000;
        nums[1] = 1;
        for (int i = 2; i < 9999; i++) {
            nums[i] = i;
        }
        nums[9999] = 1; // 这里放一个重复元素
        boolean b = containsDuplicateV2(nums);
        System.out.println(b);
    }

}
