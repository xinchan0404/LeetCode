package offer.I.pass1;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * @author xinchan
 * @version 1.0.1 2022-04-29
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int midVal = numbers[mid];
            if (midVal > numbers[right]) {
                left = mid + 1;
            } else if (midVal < numbers[right]) {
                right = mid;
            } else{
                right--;
            }
        }
        return numbers[right];
    }
}
