package crackingInterview.pass1.ch01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-16
 */
public class Solution01 {
    /**
     * 面试题 01.01. 判定字符是否唯一 - 位运算
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        int bits = 0;

        return true;
    }


    /**
     * 面试题 01.01. 判定字符是否唯一 - 数组模拟
     * @param astr
     * @return
     */
    public boolean isUnique2(String astr) {
        int n = astr.length();
        boolean[] counter = new boolean[26];
        for (int i = 0; i < n; i++) {
            int index = astr.charAt(i) - 'a';
            if (!counter[index]) {
                counter[index] = true;
            } else {
                return false;
            }
        }
        return false;
    }


    /**
     * 面试题 01.01. 判定字符是否唯一 - Set
     * @param astr
     * @return
     */
    public boolean isUnique1(String astr) {
        int n = astr.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!set.add(astr.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
