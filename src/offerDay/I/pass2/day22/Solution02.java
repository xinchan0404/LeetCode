package offerDay.I.pass2.day22;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @author xinchan
 * @version 1.0.1 2022-03-22
 */
public class Solution02 {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one ^ two;
    }
}
