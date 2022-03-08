package codingInterviewDay_2.day05;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution02 {
    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = numbers[mid];
            if (midVal > numbers[right]) {
                left = mid + 1;
            } else if (midVal < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
