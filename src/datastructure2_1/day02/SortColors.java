package dataStructure2_1.day02;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * @author xinchan
 * @version 1.0.1 2021-12-24
 */
public class SortColors {
    public static void main(String[] args) {
        /*
         * 测试 sortColors()
         */
        SortColors sortColors = new SortColors();
        int[] nums = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            nums = new int[]{2, 0, 2, 1, 1, 0};
//            sortColors.sortColors(nums);  // 1000000: 15 ms
            sortColors.sortColors1(nums);  // 1000000: 15 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 颜色分类 - 单指针法
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int cur = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[cur];
                nums[cur++] = tmp;
            }
        }

        for (int i = cur; i < len; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[cur];
                nums[cur++] = tmp;
            }
        }
    }

    /**
     * 颜色分类 - 双指针法
     * @param nums
     */
    public void sortColors1(int[] nums) {

    }
}
