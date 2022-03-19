package offerDay.first.pass2.day04;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution03 {
    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = 0;
        for (int i = 0; i < n; i++) {
            missing ^= nums[i];
            missing ^= i;
        }
        return missing ^ n;
    }

    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        int missing = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            missing -= nums[i];
        }
        return missing;
    }
}
