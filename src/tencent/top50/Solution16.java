package tencent.top50;

import java.util.Arrays;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-17
 */
public class Solution16 {
    private int target;
    private int diff=Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        this.target = target;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            twoSum(nums, left, right);
            if(diff==0)break;
            left++;
        }
        return -diff + target;
    }

    private void twoSum(int[] nums, int left, int right) {
        int val = nums[left++];
        while (left < right) {
            int tmp = target - (val + nums[left] + nums[right]);
            if(Math.abs(tmp)<Math.abs(diff))  diff=tmp;
            if (tmp < 0) {
                right--;
            } else if (tmp > 0) {
                left++;
            } else {
                return;
            }
        }
    }
}
