package weeks.double74;

import java.util.Arrays;

/**
 * 6020. 将数组划分成相等数对
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Solution01 {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
