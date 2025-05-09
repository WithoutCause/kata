package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarrays1248 {

    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i] & 1;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(5 & 1);
    }

}
