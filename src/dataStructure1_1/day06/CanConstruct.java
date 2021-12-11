package dataStructure1_1.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 提示：
 * 1. 1 <= ransomNote.length, magazine.length <= 105
 * 2. ransomNote 和 magazine 由小写英文字母组成
 *
 * @author xinchan
 * @version 1.0.1 2021-11-30
 */
public class CanConstruct {
    public static void main(String[] args) {
        String ransomNote = "aac";
        String magazine = "baacd";

        boolean canConstruct = canConstruct1(ransomNote, magazine);

        System.out.println(canConstruct);
    }

    /**
     * 判断 magazine 是否可以构建 ransomNote - HashMap
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);

            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断 magazine 是否可以构建 ransomNote - 数组模拟 HashMap
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct1(String ransomNote, String magazine) {
        int[] count = new int[26];  // 记录 magazine 频数

        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (count[index] > 0) {
                count[index]--;
            } else {
                return false;
            }
        }

        return true;
    }
}
