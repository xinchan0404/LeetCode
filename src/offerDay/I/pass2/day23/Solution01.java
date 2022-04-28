package offerDay.I.pass2.day23;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的
 *
 * @author xinchan
 * @version 1.0.1 2022-03-22
 */
public class Solution01 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            if (candidate == num) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return candidate;
    }
}

class Solution01_ {
    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        int leftWinner = divideAndConquer(nums, left, mid);
        int rightWinner = divideAndConquer(nums, mid + 1, right);
        if (leftWinner == rightWinner) {
            return leftWinner;
        }
        int cntLeft = counter(nums, left, mid, leftWinner);
        int cntRight = counter(nums, mid + 1, right, rightWinner);
        return cntLeft > cntRight ? leftWinner : rightWinner;
    }

    private int counter(int[] nums, int left, int right, int winner) {
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == winner) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution01_ solution01_ = new Solution01_();
        int[] nums = {1,2,1,2,2,1,3,1,5};
        int i = solution01_.majorityElement(nums);
        System.out.println(i);
    }
}
