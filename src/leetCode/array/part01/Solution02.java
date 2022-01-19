package leetCode.array.part01;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-18
 */
public class Solution02 {
    /**
     * 27. 移除元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int tail = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                if (i != tail) {
                    nums[tail] = nums[i];
                    nums[i] = val;
                }
                tail++;
            }
        }

        return tail;
    }
}
