package weeks.single284;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-13
 */
public class Solution01 {
    /**
     * 6031. 找出数组中的所有 K 近邻下标
     * @param nums
     * @param key
     * @param k
     * @return
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) <= k && nums[j] == k) {
                    list.add(j);
                    break;
                }
            }
        }
        return list;
    }
}
