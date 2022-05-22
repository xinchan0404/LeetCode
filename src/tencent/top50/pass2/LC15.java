package tencent.top50.pass2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author xinchan
 * @version 1.0.1 2022-￥05-22
 */
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            List<int[]> pos = towSum(nums, i + 1, n - 1, nums[i]);
            if (!pos.isEmpty()) {
                for (int[] arr : pos) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[arr[0]]);
                    list.add(nums[arr[1]]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private List<int[]> towSum(int[] nums, int left, int right, int target) {
        List<int[]> lists = new ArrayList<>();
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                int[] arr = new int[2];
                arr[0] = left;
                arr[1] = right;
                lists.add(arr);
                int tmp = nums[left];
                left++;
                right--;
                while (left < right && nums[left] == tmp) {
                    left++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        LC15 lc15 = new LC15();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = lc15.threeSum(nums);
    }
}
