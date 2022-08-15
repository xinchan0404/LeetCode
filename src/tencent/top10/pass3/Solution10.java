package tencent.top10.pass3;

/**
 * 3. 无重复字符的最长子串
 * @author xinchan
 * @version 1.0.1 2022-08-15
 */
public class Solution10 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        int max = 0;
        char[] cnt = new char[128];
        int left = -1, right = -1;
        while (++right < n) {
            int index = s.charAt(right);
            cnt[index]++;
            while (cnt[index] > 1) {
                cnt[s.charAt(++left)]--;
            }
            max = Math.max(right - left, max);
        }
        return max;
    }
}
