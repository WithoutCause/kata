package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        // 用 set 去重
        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        // 再遍历
        Set<Integer> iterSet1;
        Set<Integer> iterSet2;
        if (nums1Set.size() >= nums2Set.size()) {
            iterSet1 = nums1Set;
            iterSet2 = nums2Set;
        } else {
            iterSet1 = nums2Set;
            iterSet2 = nums1Set;
        }

        Set<Integer> resSet = new HashSet<>();
        for (Integer i : iterSet1) {
            if (iterSet2.contains(i)) {
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        int[] intersection = intersection(nums1, nums2);
        System.out.println(intersection);
    }

}
