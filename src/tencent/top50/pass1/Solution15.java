package tencent.top50.pass1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-17
 */
public class Solution15 {
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            twoSums(nums, left, right, -nums[left]);
            int val = nums[left];
            while (left < right - 1 && val == nums[left]) {
                left++;
            }
        }
        return lists;
    }

    private void twoSums(int[] nums, int left, int right, int target) {
        int val = nums[left++];
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                int oldVal = nums[left];
                while (left < right && nums[left] == oldVal) {
                    left++;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(val);
                list.add(nums[left]);
                list.add(nums[right]);
                lists.add(list);
                int leftVal = nums[left];
                while (left < right && nums[left] == leftVal) {
                    left++;
                }
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution15.threeSum(nums);
        System.out.println(lists);
    }
}
