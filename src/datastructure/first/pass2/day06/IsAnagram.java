package datastructure.first.pass2.day06;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * @author xinchan
 * @version 1.0.1 2021-12-16
 */
public class IsAnagram {
    public static void main(String[] args) {
        /*
         * 测试 isAnagram()
         */
        IsAnagram isAnagram = new IsAnagram();

//        String s = "anagram";
//        String t = "nagaram";
        String s = "anagras";
        String t = "nagaram";

        boolean isOrNot = isAnagram.isAnagram1(s, t);

        System.out.println(isOrNot);
    }

    /**
     * 有效的字母异位词 - 数组记录频数
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sCnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int index = t.charAt(i) - 'a';
            sCnt[index]--;
            if (sCnt[index] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 有效的字母异位词 - 数组排序
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }

        return true;
    }
}
