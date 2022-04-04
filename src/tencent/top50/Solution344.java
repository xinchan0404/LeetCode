package tencent.top50;

/**
 * 344. 反转字符串
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int n = s.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }
}
