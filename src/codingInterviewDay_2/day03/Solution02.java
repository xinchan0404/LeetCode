package codingInterviewDay_2.day03;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-09
 */
public class Solution02 {
    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
