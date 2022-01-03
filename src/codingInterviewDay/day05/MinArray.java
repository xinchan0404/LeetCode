package codingInterviewDay.day05;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author xinchan
 * @version 1.0.1 2022-01-03
 */
public class MinArray {
    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        int[] numbers = {};
        int minVal = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            minVal = minArray
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(minVal);
    }

    /**
     * 旋转数组中的最小数字 - 二分查找
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = numbers[mid];

            if ()
        }
    }
}
