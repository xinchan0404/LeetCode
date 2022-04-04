package tencent.top50;

/**
 * 169. 多数元素
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            cnt += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
