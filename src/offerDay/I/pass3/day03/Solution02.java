package offerDay.I.pass3.day03;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * @author xinchan
 * @version 1.0.1 2022-05-01
 */
public class Solution02 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
