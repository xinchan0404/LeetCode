package offerDay.I.pass1.day04;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @author xinchan
 * @version 1.0.1 2022-￥06-27
 */
public class Solution03 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > mid) {
                right = mid - 1;
            } else if (nums[mid] == mid) {
                left = mid + 1;
            }
        }
        return left + 1;
    }
}

class Solution03_ {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        for (int i = 0; i < n + 1; i++) {
            ans ^= i;
        }
        return ans;
    }
}

class Solution03__ {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
