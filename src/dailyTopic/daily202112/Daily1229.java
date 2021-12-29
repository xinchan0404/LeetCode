package dailyTopic.daily202112;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1995. 统计特殊四元组
 * 提示：
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 *
 * @author xinchan
 * @version 1.0.1 2021-12-29
 */
public class Daily1229 {
    public static void main(String[] args) {
        /*
         * 测试 countQuadruplets()
         */
        Daily1229 daily1229 = new Daily1229();
        int[] nums = {1, 1, 1, 3, 5};
        int cnt = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            cnt = daily1229.countQuadruplets(nums);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(cnt);
    }

    /**
     * 统计特殊四元组 - HashMap
     *
     * @param nums
     * @return
     */
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 2; i >= 2; i--) {
            map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            for (int j = 0; j < i - 1; j++) {
                for (int k = j + 1; k < i; k++) {
                    cnt += map.getOrDefault(nums[i] + nums[j] + nums[k], 0);
                }
            }
        }

        return cnt;
    }
}
