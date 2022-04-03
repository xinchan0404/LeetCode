package tencent.top50;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-02
 */
public class Solution557 {
    public String reverseWords(String s) {
        int n = s.length();
        int right = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (right < n) {
            StringBuilder builder = new StringBuilder();
            char c;
            while (right < n && (c = s.charAt(right)) != ' ') {
                builder.append(c);
                right++;
            }
            stringBuilder.append(builder.reverse());
            stringBuilder.append(' ');
            right++;
        }
        return stringBuilder.toString().trim();
    }
}

class Solution577_ {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int left = 0;
        int right = 0;
        while (right < n) {
            while (right < n && chars[right] != ' ') {
                right++;
            }
            int l = left;
            int r = right;
            while (l <= r) {
                swap(chars, l, r);
                l++;
                r--;
            }
            right++;
            left = right;
        }
        return new String(chars);
    }

    private void swap(char[] arr, int left, int right) {
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
