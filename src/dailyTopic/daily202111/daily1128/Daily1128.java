package dailyTopic.daily202111.daily1128;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * 提示:
 * 1. 1 <= s.length, p.length <= 3 * 104
 * 2. s 和 p 仅包含小写字母
 *
 * @author xinchan
 * @version 1.0.1 2021-11-28
 */
public class Daily1128 {
    public static void main(String[] args) {
        /*
         * 测试用例
         */
//        String s = "abab";
//        String p = "ab";
//        String s = "cbaebabacd";
//        String p = "abc";
        String s = "baa";
        String p = "aa";

        List<Integer> list;

//        list = findAnagrams(s, p);
//        list = findAnagrams1(s, p);
        list = findAnagrams2(s, p);

        System.out.println(list);
    }

    /**
     * 找到字符串中所有字母异位词 - 暴力法，没有考虑滑动窗口每次只有一个位置有变化，也就是头尾互换
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();

        int[] countP = new int[26];
        for (int i = 0; i < len2; i++) {
            countP[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len1 - len2 + 1; i++) {
            int[] countS = new int[26];
            for (int j = i; j < len2 + i; j++) {
                countS[s.charAt(j) - 'a']++;
            }
            if (Arrays.equals(countP, countS)) {
                list.add(i);
            }
        }

        return list;
    }

    /**
     * 找到字符串中所有字母异位词 - 暴力优化、滑动窗口
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();

        if (len1 < len2) {
            return list;
        }

        int[] countP = new int[26];
        int[] countS = new int[26];

        for (int i = 0; i < len2; i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(countP, countS)) {
            list.add(0);
        }

        for (int i = 0; i < len1 - len2; i++) {
            /*
             * 考虑滑动窗口每次仅滑动一个位置，因此仅仅是头尾互换
             */
            countS[s.charAt(i) - 'a']--;
            countS[s.charAt(i + len2) - 'a']++;

            if (Arrays.equals(countP, countS)) {
                list.add(i + 1);
            }
        }

        return list;
    }

    /**
     * 找到字符串中所有字母异位词 - 滑动窗口优化
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();

        if (len1 < len2) {
            return list;
        }

        int[] count = new int[26];
        int diff = 0;  // 滑动窗口 与 字符串p 中的不同字符串数

        for (int i = 0; i < len2; i++) {
            count[p.charAt(i) - 'a']--;
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }

        if (diff == 0) {
            list.add(0);
        }

        for (int i = 0; i < len1 - len2; i++) {
            /*
             * 考虑滑动窗口每次仅滑动一个位置，因此仅仅是头尾互换.
             * 但是优化后，从维护两个位置数组转变为维护一个差异值，但是流程并没有变化，只是没有更新两个位置数组而已
             */
            int head = count[s.charAt(i) - 'a'];
            if (head == 1) {
                diff--;
            } else if (head == 0) {
                diff++;
            }
            count[s.charAt(i) - 'a']--;

            int tail = count[s.charAt(i + len2) - 'a'];
            if (tail == -1) {
                diff--;
            } else if (tail == 0) {
                diff++;
            }
            count[s.charAt(i + len2) - 'a']++;

            if (diff == 0) {
                list.add(i + 1);
            }

        }

        return list;
    }
}
