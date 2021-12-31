package codingInterviewDay.day04;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 限制：
 * 2 <= n <= 100000
 *
 * @author xinchan
 * @version 1.0.1 2021-12-31
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        /*
         * 测试 findRepeatNumber()
         */
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int[] nums = {};
        int repeatNumber = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            repeatNumber = findRepeatNumber.findRepeatNumber(nums);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(repeatNumber);
    }

    /**
     * 数组中重复的数字 - 排序筛查
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int num = nums[i];
                nums[i] = nums[num];
                nums[num] = num;
            }
        }
        return -1;
    }
}
