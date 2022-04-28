package offerDay.I.pass2.day22;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * @author xinchan
 * @version 1.0.1 2022-03-22
 */
public class Solution01 {
    public int[] singleNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        int bit = 1;
        while ((ans & bit) == 0) {
            bit <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & bit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}
