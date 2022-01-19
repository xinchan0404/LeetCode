package leetCode.array.part01;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-18
 */
public class Solution04 {
    /**
     * 80. 删除有序数组中的重复项 II - 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int tail = 0;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[tail]) {
                nums[++tail] = nums[i];
                flag = false;
            } else {
                if (!flag) {
                    nums[++tail] = nums[i];
                    flag = true;
                }
            }
        }

        return tail + 1;
    }
}
