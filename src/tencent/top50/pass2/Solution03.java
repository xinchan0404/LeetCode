package tencent.top50.pass2;

/**
 * 5. 最长回文子串
 * @author xinchan
 * @version 1.0.1 2022-08-17
 */
public class Solution03 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        String ans = "";
        for (int i = 0; i < n; i++) {
            String s1 = getSubString(s, i, i);
            String s2 = getSubString(s, i, i + 1);
            String longer = s1.length() >= s2.length() ? s1 : s2;
            ans = ans.length() >= longer.length() ? ans : longer;
        }
        return ans;
    }

    private String getSubString(String s, int left, int right) {
        int n = s.length();
        while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
