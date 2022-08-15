package tencent.top10.pass3;

/**
 * 5. 最长回文子串
 * @author xinchan
 * @version 1.0.1 2022-08-03
 */
public class Solution06 {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            String s1 = isPalindrome(s, i, i);
            String s2 = isPalindrome(s, i, i + 1);
            String longer = s1.length() >= s2.length() ? s1 : s2;
            ans = ans.length() >= longer.length() ? ans : longer;
        }
        return ans;
    }

    private String isPalindrome(String s, int left, int right) {
        int n = s.length();
        while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
