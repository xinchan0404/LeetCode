package crackingTheCodingInterview.ch01;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-17
 */
public class Solution04 {
    /**
     * 面试题 01.04. 回文排列 - 数组模拟
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            cnt[index]++;
        }

        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
