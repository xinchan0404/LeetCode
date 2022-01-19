package crackingTheCodingInterview.ch01;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-17
 */
public class Solution09 {
    /**
     * 面试题 01.09. 字符串轮转 -
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s2s2 = s2 + s2;
            return isSubstring(s2s2, s1);
        }
        return false;
    }

    /**
     *
     * @param big
     * @param small
     * @return
     */
    private boolean isSubstring(String big, String small) {
        return big.contains(small);
    }
}
