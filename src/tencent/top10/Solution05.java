package tencent.top10;

/**
 * 5. 最长回文子串
 * @author xinchan
 * @version 1.0.1 2022-03-26
 */
public class Solution05 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n - 1; i++) {
            String s1 = getPalindrome(s, i, i);
            String s2 = getPalindrome(s, i, i + 1);
            String tmp = s1.length() > s2.length() ? s1 : s2;
            ans = ans.length() > tmp.length() ? ans : tmp;
        }
        return ans;
    }

    private String getPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
