package tencent.top50.pass3;

/**
 * 26. 删除有序数组中的重复项
 * @author xinchan
 * @version 1.0.1 2023-02-23
 */
public class Solution13 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, left = 0, right = 0;

        while (right < n) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                nums[++left] = nums[right];
            }
        }

        return left;
    }
}
