package tencent.top50;

/**
 * 26. 删除有序数组中的重复项
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int tail = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[tail]) {
                nums[++tail] = nums[i];
            }
        }
        return tail + 1;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int ans = solution26.removeDuplicates(nums);
        System.out.println(ans);
    }
}
