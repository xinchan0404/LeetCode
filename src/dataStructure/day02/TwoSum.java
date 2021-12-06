package dataStructure.day02;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-25
 */
public class TwoSum {
    public static void main(String[] args) {
        /*
         * 测试 twoSum()
         */
/*        int[] nums = {2, 7, 11, 15};
        int target = 9;*/
/*        int[] nums = {3, 4, 2, 12};
        int target = 6;*/
        int[] nums = {1, 5, 5, 2, 12};
        int target = 10;

//        int[] loc = twoSum(nums, target);  // 哈希表
        int[] loc = twoSum1(nums, target);  // 官方题解的哈希表

        System.out.println(Arrays.toString(loc));
    }

    /**
     * 两数之和
     * 提示：
     * 1. 2 <= nums.length <= 104
     * 2. -109 <= nums[i] <= 109
     * 3. -109 <= target <= 109
     * 4. 只会存在一个有效答案
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        /*
         * 将数据全部存入 HashMap
         */
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        int[] loc = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.remove(i);
            if (map.containsValue(target - nums[i])) {
                loc[0] = i;
                break;
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == target - nums[loc[0]]) {
                loc[1] = key;
                return loc;
            }
        }

        return new int[0];
    }


    /**
     * 两数之和-哈希表
     * 官方题解
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];  // 如果没有符合要求的结果，返回空数组
    }
}
