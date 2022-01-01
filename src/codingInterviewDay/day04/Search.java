package codingInterviewDay.day04;

/**
 * 704. 二分查找
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的
 * n 将在 [1, 10000]之间
 * nums 的每个元素都将在 [-9999, 9999]之间
 *
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 10;
        int num = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            num = search.search(nums, target);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(num);
    }

    /**
     * 在排序数组中查找数组I
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, false) == -1? 0 : binarySearch(nums, target, false) - binarySearch(nums, target, true) + 1;
    }

    /**
     * 二分查找
     * 
     * @param nums
     * @param target
     * @param isLeft true for first position; false for last position
     * @return
     */
    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (isLeft && mid != 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else if (!isLeft && mid != nums.length - 1 && nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        }

        return -1;
    }
}
