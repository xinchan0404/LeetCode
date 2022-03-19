package offerDay.first.pass2.day22;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-05
 */
public class Solution01 {
    /**
     * 剑指 Offer 56 - I. 数组中数字出现的次数 -
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        int diff = 1;
        while ((diff & res) == 0) {
            diff <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((diff & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}
