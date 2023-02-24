package tencent.top50.pass3;

/**
 * 33. 搜索旋转排序数组
 *
 * @author xinchan
 * @version 1.0.1 2023-02-23
 */
public class Solution14 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

class Solution14_1 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] < nums[mid]) {
                int ans = binarySearch(nums, left, mid - 1, target);
                if (ans != -1) {
                    return ans;
                } else {
                    left = mid + 1;
                }
            } else {
                int ans = binarySearch(nums, mid + 1, right, target);
                if (ans != -1) {
                    return ans;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target> nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
