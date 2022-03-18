package codingInterviewDay_2.day05;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-08
 */
public class Solution02 {
    /**
     * 剑指 Offer 11. 旋转数组的最小数字 - 二分查找
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
