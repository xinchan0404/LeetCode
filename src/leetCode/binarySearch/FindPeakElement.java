package leetCode.binarySearch;

/**
 * 162. 寻找峰值
 * 提示：
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class FindPeakElement {
    public static void main(String[] args) {
        /*
         * 测试 findPeakElement()
         */
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};
        int pos = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos = findPeakElement.findPeakElement(nums);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(pos);
    }

    /**
     * 寻找峰值 - 二分查找
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
