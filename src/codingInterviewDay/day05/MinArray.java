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
//        int[] numbers = {3, 4, 5, 1, 2};
//        int[] numbers = {2, 2, 2, 0, 1};
        int[] numbers = {1, 2, 2, 3, 4};
//        int[] numbers = {3, 3, 1, 3, 3};
        int minVal = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            minVal = minArray.minArray(numbers);
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
        if (numbers[left] < numbers[right]) {
            return numbers[left];
        }

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = numbers[mid];

            if (numbers[left] <= midVal) {
                left = mid + 1;
            } else {
                right = mid;
            }
            if (numbers[left] <= numbers[right]) {
                return numbers[left];
            }
        }

        return numbers[left];
    }
}
