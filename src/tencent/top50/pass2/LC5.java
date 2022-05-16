package tencent.top50.pass2;

/**
 * 5. 最长回文子串
 * @author xinchan
 * @version 1.0.1 2022-￥05-15
 */
public class LC5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            String s1 = getStr(s, i, i);
            String s2 = getStr(s, i, i + 1);
            String tmp = s1.length() > s2.length() ? s1 : s2;
            ans = tmp.length() > ans.length() ? tmp : ans;
        }

        return ans;
    }

    private String getStr(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right <= n - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
