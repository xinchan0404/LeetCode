package tencent.top10.pass4.basic;

/**
 * 3. 无重复字符的最长子串
 * @author xinchan
 * @version 1.0.1 2023-02-19
 */
public class Solution9 {
    public int lengthOfLongestSubstring(String s) {
        char[] cnt = new char[128];
        int n = s.length();
        int left = -1, right = -1, max = 1;
        while (++right < n){
            int index = s.charAt(right);
            cnt[index]++;
            while (cnt[index] > 1) {
                cnt[s.charAt(++left)]--;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }
}
