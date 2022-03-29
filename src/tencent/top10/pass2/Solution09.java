package tencent.top10.pass2;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * @author xinchan
 * @version 1.0.1 2022-03-29
 */
public class Solution09 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        short[] cnt = new short[128];
        int ans = 1;
        while (right < n) {
            int index = chars[right];
            right++;
            cnt[index]++;
            while (cnt[index] > 1) {
                cnt[chars[left++]]--;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
