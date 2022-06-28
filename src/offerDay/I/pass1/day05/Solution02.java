package offerDay.I.pass1.day05;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * @author xinchan
 * @version 1.0.1 2022-￥06-28
 */
public class Solution02 {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
