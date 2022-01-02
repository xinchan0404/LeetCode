package codingInterviewBook.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 限制：
 * 2 <= n <= 100000
 *
 * @author xinchan
 * @version 1.0.1 2021-12-13
 */
public class DuplicationInArray {
    public static void main(String[] args) {
        /*
         * 测试 findRepeatNumber()
         */
        DuplicationInArray findRepeatNumber = new DuplicationInArray();

        int[] nums = {2, 3, 1, 0, 2, 5, 3};

        int repeat = 0;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            repeat = findRepeatNumber.findRepeatNumber(nums);  // 1000000 times: 68 ms
//            repeat = findRepeatNumber.findRepeatNumber1(nums);  // 1000000 times: 6 ms
        }
        long timeCost = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + timeCost + " ms");

        System.out.println(repeat);
    }

    /**
     * 数组中重复的数字 - Set 不能添加重复元素
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                repeat = nums[i];
                break;
            }
        }

        return repeat;
    }

    /**
     * 数组中重复的数字 - 数据全部位于 0 ~ n-1 之间
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        int repeat = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                repeat = nums[i];
                break;
            }

            while (nums[i] != i) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
                if (nums[i] == nums[nums[i]]) {
                    repeat = nums[i];
                    break;
                }
            }
        }

        return repeat;
    }
}
