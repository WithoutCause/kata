package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {

    public static int subarraySum(int[] nums, int k) {
        int res = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                res += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        int res = subarraySum(nums, k);
        System.out.println(res);
    }

}
