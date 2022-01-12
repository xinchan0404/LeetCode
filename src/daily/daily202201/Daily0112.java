package daily.daily202201;

/**
 * 334. 递增的三元子序列
 *
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class Daily0112 {
    /**
     * 递增的三元子序列 - 贪心，第一个数和第二个数尽量小
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] > second) {
                return true;
            } else if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Daily0112 daily0112 = new Daily0112();
        int[] nums = {0, 4, 2, 1, 0, -1, -3};
        boolean flag = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            flag = daily0112.increasingTriplet(nums);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(flag);
    }
}
