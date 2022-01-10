package daily.daily202111;

/**
 * @author zegxn
 * @version 1.0.1 2021-11-05
 */
public class Daily1105 {
    public static void main(String[] args) {
        // while 循环
        int[] nums_1 = {-1, 0, 3, 5, 9, 12, 14, 19, 30};
        int pos_1 = binarySearch(nums_1, 3);
        System.out.println(pos_1);

        // 递归
        int pos_2 = binarySearch(nums_1, 0, nums_1.length - 1, 30);
        System.out.println(pos_2);

        // 剑指 Offer 53 - II. 0～n-1中缺失的数字
        int[] nums_2 = {0, 1, 2, 3, 4, 5, 7};
        int pos_3 = missingNumber(nums_2);
        System.out.println(pos_3);
    }


    /*
     * while 循环
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /*
     * 递归
     */
    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) >> 1);
        if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return mid;
        }
    }

    /*
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     */
    public static int missingNumber(int[] nums) {
        int mid = 0;
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1) {
            return 1;
        }

        while (start < end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == mid) {
                start = mid + 1;
            } else if (nums[mid] > mid) {
                end = mid;
            }
        }
        return start;
    }
}
