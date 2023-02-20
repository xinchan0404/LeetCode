package tencent.top10.pass4;

/**
 * 5. 最长回文子串
 * @author xinchan
 * @version 1.0.1 2023-02-18
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            String s1 = selectPalindrome(s, i, i);
            String s2 = selectPalindrome(s, i, i + 1);
            String ss = s1.length() >= s2.length() ? s1 : s2;
            ans = ans.length() >= ss.length() ? ans : ss;
        }

        return ans;
    }

    private String selectPalindrome(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right <= n - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
