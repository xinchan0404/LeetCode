package codingInterviewDay_2.day10;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution02 {
    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串 - 动态规划、遍历
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        int len = s.charAt(1) == s.charAt(0) ? 1 : 2;
        int ans = len;
        for (int i = 2; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && s.charAt(i) != s.charAt(j)) {
                j--;
            }
            len = len < i - j ? len + 1 : i - j;
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        String s = "abcsasasdaefaea";
        int i = solution02.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
