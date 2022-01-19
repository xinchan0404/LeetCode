package daily.daily202201;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-19
 */
public class Daily0119 {
    /**
     * 219. 存在重复元素 II - 遍历，超时
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int left = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[left] == nums[j]) {
                    if (j - left <= k) {
                        return true;
                    } else {
                        left = j;
                    }
                }
            }
        }
        return false;
    }


    /**
     * 219. 存在重复元素 II - HashMap
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - map.getOrDefault(nums[i], -100000) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Daily0119 daily0119 = new Daily0119();
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean flag = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            flag = daily0119.containsNearbyDuplicate1(nums, k);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(flag);
    }
}
