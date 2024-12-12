package leetcode;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode： <a href='https://leetcode.cn/problems/two-sum/'>https://leetcode.cn/problems/two-sum/</a>
 * @author sjl
 */
public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     * example1:
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * example2:
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * example3:
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     */
    public int[] twoSum(int[] nums, int target) {
        // 两次遍历,暴露枚举所有值
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /**
     * 用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        // 使用 hash 的数据结构
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }


    //public static void main(String[] args) {
    //    int[] nums = {3,3};
    //    int target = 6;
    //    TwoSum twoSum = new TwoSum();
    //    int[] ints = twoSum.twoSum2(nums, target);
    //    System.out.println("[" + ints[0] + ", " + + ints[1] + "]");
    //}

    public static void main(String[] args) {
        LocalDate registerDate = LocalDate.of(2024, 8, 30);
        LocalDate orderDate = LocalDate.of(2024, 8, 30);;
        LocalDate nowDate = LocalDate.now();
        LocalDate minRegisterDate = nowDate.plusDays(0);

        // 会员注册时间范围
        boolean isNewUser = !registerDate.isBefore(minRegisterDate) && !registerDate.isAfter(nowDate);
        // 订单下单时间范围
        boolean isNewOrder = !orderDate.isBefore(minRegisterDate) && !orderDate.isAfter(nowDate);
        System.out.println(1);
    }
}
