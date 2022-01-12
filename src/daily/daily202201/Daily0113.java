package daily.daily202201;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class Daily0113 {
    /**
     * 747. 至少是其他数字两倍的最大数 - 排序、逆序查找
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < n; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }

        for (int num : nums) {
            if (2 * num > nums[index]) {
                return -1;
            }
        }

        return index;
    }

    /**
     * 747. 至少是其他数字两倍的最大数 - 排序、逆序查找
     * @param nums
     * @return
     */
    public int dominantIndex1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < n; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }
        Arrays.sort(nums);
        if (nums[n - 1] >= 2 * nums[n - 2]) {
            return index;
        }
        return -1;
    }
}
