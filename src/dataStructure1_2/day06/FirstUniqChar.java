package dataStructure1_2.day06;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 387. 字符串中的第一个唯一字符
 * 提示：你可以假定该字符串只包含小写字母
 *
 * @author xinchan
 * @version 1.0.1 2021-12-16
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        /*
         * 测试 firstUniqChar()
         */
        FirstUniqChar firstUniqChar = new FirstUniqChar();

        String s = "acaadcad";

        int loc = firstUniqChar.firstUniqChar1(s);

        System.out.println(loc);
    }

    /**
     * 字符串中的第一个唯一字符 - 遍历、数组记录频数
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int loc = -1;
        int[] nums = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            nums[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i) - 'a'] == 1) {
                loc = i;
                break;
            }
        }

        return loc;
    }

    /**
     * 字符串中的第一个唯一字符 - 数组记录索引
     *
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        int[] indexes = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (indexes[index] == 0) {
                indexes[index] = 1;
            } else {
                indexes[index] = -1;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (indexes[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 字符串中的第一个唯一字符 - deque
     *
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        return 0;
    }
}
