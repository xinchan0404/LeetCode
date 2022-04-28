package offerDay.I.pass1.day13;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution03 {
    /**
     * 剑指 Offer 58 - I. 翻转单词顺序 - 双指针
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        int right = n - 1;
        int left = right;
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            if (left == -1) {
                stringBuilder.append(s, 0, right + 1);
                break;
            } else {
                stringBuilder.append(s, left + 1, right + 1).append(" ");
            }
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return stringBuilder.toString();
    }
}
