package tencent.top50.pass1;

/**
 * 148. 排序链表
 * @author xinchan
 * @version 1.0.1 2022-04-05
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
