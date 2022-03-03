package codingInterviewDay_2.day13;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution02 {
    /**
     * 剑指 Offer 57. 和为s的两个数字 - 双指针
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        if (nums[head] >= target) {
            return new int[0];
        }
        while (head < tail) {
            if (nums[head] + nums[tail] > target) {
                tail--;
            } else if (nums[head] + nums[tail] < target) {
                head++;
            } else {
                return new int[] {nums[head], nums[tail]};
            }
        }
        return new int[0];
    }
}
