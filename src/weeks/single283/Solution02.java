package weeks.single283;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-06
 */
public class Solution02 {
    /**
     * 6017. 向数组中追加 K 个整数
     *
     * @param nums
     * @param k
     * @return
     */
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        int j = 1;
        for (int i = 0; i < n; i++) {
            if (j > nums[i]) {
                continue;
            }
            while (k > 0 && j < nums[i]) {
                sum += j;
                k--;
                j++;
            }
            j++;
        }
        for (int i = 0; i < k; i++) {
            sum += j;
            j++;
        }

        return sum;
    }
}
