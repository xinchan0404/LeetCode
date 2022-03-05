package codingInterviewDay_2.day23;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-05
 */
public class Solution01 {
    /**
     * 剑指 Offer 39. 数组中出现次数超过一半的数字 - 排序
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 剑指 Offer 39. 数组中出现次数超过一半的数字 - BM 投票算法
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int candidate = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                candidate = nums[i];
            }
            cnt += candidate == nums[i] ? 1 : -1;
        }

        return candidate;
    }

    /**
     * 剑指 Offer 39. 数组中出现次数超过一半的数字 - 分治
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int left, int right) {
        // 分治结束标志
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) >>> 1;
        int leftWinner = majorityElementRec(nums, left, mid);
        int rightWinner = majorityElementRec(nums, mid + 1, right);

        if (leftWinner == rightWinner) {
            return leftWinner;
        }

        int leftCnt = countRange(nums, leftWinner, left, mid);
        int rightCnt = countRange(nums, rightWinner, mid + 1, right);

        return leftCnt > rightCnt ? leftWinner : rightWinner;
    }

    private int countRange(int[] nums, int num, int left, int right) {
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        int[] nums = {2,1,2,3,2,2,5,2,4};
        int i = solution01.majorityElement2(nums);
        System.out.println(i);
    }
}
