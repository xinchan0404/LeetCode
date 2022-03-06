package weeks.double73;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-05
 */
public class Solution01 {
    /**
     * 6024. 数组中紧跟 key 之后出现最频繁的数字
     * @param nums
     * @param key
     * @return
     */
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        int target = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val > max) {
                max = val;
                target = entry.getKey();
            }
        }
        return target;
    }
}
