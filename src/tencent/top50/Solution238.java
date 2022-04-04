package tencent.top50;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = 1; i < n; i++) {
            right[n - 1 - i] = right[n - i] * nums[n - i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}

class Solution238_ {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int right = 1;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            ans[n - 1 - i] *= right;
            right *= nums[n - 1 - i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution238_ solution238_ = new Solution238_();
        int[] nums = {1,2,3,4};
        int[] ans = solution238_.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }
}
