package weeks.single284;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-13
 */
public class Solution03 {
    /**
     * 5227. K 次操作后最大化顶端元素
     * @param nums
     * @param k
     * @return
     */
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        int pos = 0;
        for (int i = 0; i < Math.min(k, n); i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                pos = i;
            }
        }
        return 0;
    }
}
