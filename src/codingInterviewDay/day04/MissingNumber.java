package codingInterviewDay.day04;

public class MissingNumber {
    public static void main(String[] args) {
        /*
         * 测试 missingNumber()
         */
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = { 0, 1, 2, 3, 4, 5, 7, 8 };
        int missing = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            // missing = missingNumber.missingNumber(nums);
            // missing = missingNumber.missingNumber1(nums);
            missing = missingNumber.missingNumber2(nums);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(missing);
    }

    /**
     * 0～n-1中缺失的数字 - 暴力
     * 
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 0～n-1中缺失的数字 - 位运算、异或
     * 
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        for (int i = 0; i < nums.length + 1; i++) {
            xor ^= i;
        }

        return xor;
    }

    /**
     * 0～n-1中缺失的数字 - 二分查找
     * 
     * @param nums
     */
    public int missingNumber2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            }
        }

        return left;
    }
}
