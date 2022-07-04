package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode： <a href='https://leetcode.cn/problems/minimum-absolute-difference/'>https://leetcode.cn/problems/minimum-absolute-difference/</a>
 * @author sjl
 */
public class MinimumAbsDifference {
    /**
     * 给你个整数数组 arr，其中每个元素都 不相同。
     *
     * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
     *
     * example1:
     * 输入：arr = [4,2,1,3]
     * 输出：[[1,2],[2,3],[3,4]]
     *
     *
     * example2:
     * 输入：arr = [1,3,6,10,15]
     * 输出：[[1,3]]
     *
     * example3:
     * 输入：arr = [3,8,-10,23,19,-4,-14,27]
     * 输出：[[-14,-10],[19,23],[23,27]]
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // 解题思路：最小绝对差只会出现在相领的两个数之间，先排序
        // 遍历数组，计算 i 和 i+1 的差值，与 Integer.MAX_VALUE 比较(初始值设为该值)，小就加入返回集合中
        Arrays.sort(arr);
        int best = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int delta = arr[i + 1] - arr[i];
            if (delta < best) {
                // 找到了更小的值
                best = delta;
                result.clear();

                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                result.add(pair);
            } else if (delta == best) {
                // 相同的值，只需要将该值加入 result 即可
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                result.add(pair);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        MinimumAbsDifference minimumAbsDifference = new MinimumAbsDifference();
        List<List<Integer>> lists = minimumAbsDifference.minimumAbsDifference(arr);
        System.out.println(lists);
    }
}
