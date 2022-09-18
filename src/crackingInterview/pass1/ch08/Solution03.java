package crackingInterview.pass1.ch08;

/**
 * 面试题 08.03. 魔术索引
 * @author xinchan
 * @version 1.0.1 2022-09-16
 */
public class Solution03 {
    public static void main(String[] args) {
        int[] nums = {1,1,3,4,5,5,6};
        Solution03 solution03 = new Solution03();
        int magicIndex = solution03.findMagicIndex(nums);
        System.out.println(magicIndex);
    }

    public int findMagicIndex(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    private int recur(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >>> 1;
        int leftAns = recur(nums, left, mid - 1);
        if (leftAns != -1) {
            return left;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return recur(nums, mid + 1, right);
    }
}
