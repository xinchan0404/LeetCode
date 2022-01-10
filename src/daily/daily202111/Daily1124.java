package daily.daily202111;

import java.util.HashMap;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-24
 */
public class Daily1124 {
    public static void main(String[] args) {
        /*
         * 测试 originalDigits()
         */
        String s = "owoztneoer";
        String originalDigits = originalDigits(s);
        System.out.println("originalDigits=" + originalDigits);
    }

    /**
     * 从英文中重建数字
     * 提示：
     * 1 <= s.length <= 105
     * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
     * s 保证是一个符合题目要求的字符串
     *
     * @param s
     * @return
     */
    public static String originalDigits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] count = new int[10];

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        /*
         * 只在唯一一个英文数字中出现过的字母
         */
        count[0] = map.getOrDefault('z', 0);  // 0
        count[2] = map.getOrDefault('w', 0);  // 2
        count[4] = map.getOrDefault('u', 0);  // 4
        count[6] = map.getOrDefault('x', 0);  // 6
        count[8] = map.getOrDefault('g', 0);  // 8

        /*
         * 根据已经求得的结果推断剩余英文数字出现次数
         */
        count[1] = map.getOrDefault('o', 0) - count[0] - count[2] - count[4];
        count[3] = map.getOrDefault('h', 0) - count[8];
        count[5] = map.getOrDefault('f', 0) - count[4];
        count[7] = map.getOrDefault('s', 0) - count[6];
        count[9] = map.getOrDefault('i', 0) - count[5] - count[6] - count[8];

//        System.out.println(Arrays.toString(count));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                stringBuilder.append((char)(i + '0'));
            }
        }

        return stringBuilder.toString();
    }
}
