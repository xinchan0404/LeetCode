package dataStructure2_1.day01;

import java.util.ArrayList;
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
        int[] nums = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> lists = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            lists = threeSum.threeSum(nums);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(lists);
    }

    /**
     * 三数之和 -
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        return null;
    }
}
