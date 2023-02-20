package tencent.top10.pass5;

/**
 * 5. 最长回文子串
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Solution6 {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            String s1 = getPalindrome(s, i, i);
            String s2 = getPalindrome(s, i, i + 1);
            String ss = s1.length() > s2.length() ? s1 : s2;
            ans = ans.length() > ss.length() ? ans : ss;
        }

        return ans;
    }

    private String getPalindrome(String s, int left, int right) {
        int n = s.length();
        while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
