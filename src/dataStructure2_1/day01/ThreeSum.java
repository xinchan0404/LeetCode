package dataStructure2_1.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * @author xinchan
 * @version 1.0.1 2021-12-24
 */
public class ThreeSum {
    public static void main(String[] args) {
        /*
         * 测试 threeSum()
         */
        ThreeSum threeSum = new ThreeSum();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> lists = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            lists = threeSum.threeSum(nums);  // 1000000: 136 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(lists);
    }

    /**
     * 三数之和 - 拆分为两数之和、双指针法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (len < 3) {
            return lists;
        }

        Arrays.sort(nums);

        /*
         * 枚举第一个数
         */
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            /*
             * 三数之和转换为两数之和，双指针法
             */
            int target = -nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;
                    right--;
                }
            }
        }

        return lists;
    }
}
