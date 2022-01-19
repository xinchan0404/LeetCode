package leetCode.array.part01;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-18
 */
public class Solution03 {
    /**
     * 26. 删除有序数组中的重复项 I -
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int tail = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[tail]) {
                nums[++tail] = nums[i];
            }
        }
        return tail + 1;
    }
}
