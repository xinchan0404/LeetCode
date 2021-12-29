package leetCode.binarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * @author xinchan
 * @version 1.0.1 2021-12-29
 */
public class FindMin {
    public static void main(String[] args) {
        /*
         * 测试 findMin()
         */
        FindMin findMin = new FindMin();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {4};
        int[] nums = {4, 1};
        int min = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            min = findMin.findMin(nums);  // 1000000: 4 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(min);
    }

    /**
     * 寻找旋转排序数组中的最小值
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = (left + right) >>> 1;
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[right];
    }
}
