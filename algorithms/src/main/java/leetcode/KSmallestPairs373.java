package leetcode;

import java.util.*;

public class KSmallestPairs373 {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 暴力解法
        List<List<Integer>> result = new ArrayList<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                List<Integer> list = new ArrayList<>();
                list.add(num1);
                list.add(num2);
                result.add(list);
            }
        }
        result.sort(Comparator.comparing(list -> list.get(0) + list.get(1)));
        return result.subList(0, Math.min(k, result.size()));
    }

    public static List<List<Integer>> kSmallestPairsV2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        // 小顶堆，在 Java 中在 PriorityQueue
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> nums1[i[0]] + nums2[i[1]]));
        int loopCount = Math.min(nums1.length, k);
        for (int i = 0; i < loopCount; i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            int i = poll[0], j = poll[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        //int[] nums1 = {1, 7, 11};
        //int[] nums2 = {2, 4, 6};
        //int k = 3;
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 2;
        List<List<Integer>> pairs = kSmallestPairsV2(nums1, nums2, k);
        System.out.println(Arrays.toString(pairs.toArray()));
    }

}
