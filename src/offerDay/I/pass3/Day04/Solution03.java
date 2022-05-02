package offerDay.I.pass3.Day04;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @author xinchan
 * @version 1.0.1 2022-05-02
 */
public class Solution03 {
    public int missingNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans ^= i;
            ans ^= nums[i];
        }

        return ans ^ n;
    }
}

class Solution03_ {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return n * (n + 1) / 2 - sum;
    }
}

class Solution03__ {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            if (midVal == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
