package daily.daily202111;

import java.util.HashMap;
import java.util.Set;

/**
 * LeetCode 每日一题-最大单词长度乘积
 * @author zegxn
 * @version 1.0.1 2021-11-17
 */
public class Daily1117 {
    public static void main(String[] args) {
//        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};

        final long startMs = System.currentTimeMillis();
        int maxProduct = maxProduct(words);
        long timeCost = Math.subtractExact(System.currentTimeMillis(), startMs);
        System.out.println("耗时：" + timeCost * 100000000);
        System.out.println("maxProduct=" + maxProduct);


        final long startMs1 = System.currentTimeMillis();
        int maxProduct1 = maxProduct1(words);
        long timeCost1 = Math.subtractExact(System.currentTimeMillis(), startMs1);
        System.out.println("耗时：" + timeCost1);
        System.out.println("maxProduct=" + maxProduct);
    }

    /**
     * 将字符串转换为 26 bit 长度的序列
     * @param words
     * @return
     */
    public static int maxProduct(String[] words) {
        int length = words.length;  // 字符串数组长度
        int[] mark = new int[length];

        /*
         * 遍历字符串数组，将每个字符串通过位操作转换为长度为 26 的二进制序列
         * 二进制序列中每一位顺序对应每一个字母是否出现，出现了为 1，没有出现为 0
         */
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();

            for (int j = 0; j < wordLength; j++) {
                mark[i] |= 1 << word.charAt(j) - 'a';
            }
        }

        /*
         * 遍历 mark 数组，如果 & 位操作结果为 0，则说明没有重复字母，可以计算长度乘积并更新 maxProduct
         */
        int maxProduct = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((mark[i] & mark[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }

        return maxProduct;
    }

    /**
     * 位运算优化
     * @param words
     * @return
     */
    public static int maxProduct1(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = words.length;

        /*
         * 如果字符串转换后的序列相同，取长度大者存入 map 中
         */
        for (int i = 0; i < length; i++) {
            int mark = 0;  // 26 bit 二进制序列
            String word = words[i];
            int wordLength = word.length();

            for (int j = 0; j < wordLength; j++) {
                mark |= 1 << word.charAt(j) - 'a';
            }
            
            if (wordLength > map.getOrDefault(mark, 0)) {
                map.put(mark, wordLength);
            }
        }

        /*
         * 只需要对 map 中的元素进行运算即可
         */
        int maxProduct = 0;
        Set<Integer> markSet = map.keySet();
        for (Integer mark1 : markSet) {
            int wordLength1 = map.get(mark1);
            for (Integer mark2 : markSet) {
                int wordLength2 = map.get(mark2);
                if ((mark1 & mark2) == 0) {
                    maxProduct = Math.max(maxProduct, wordLength1 * wordLength2);
                }
            }
        }

        return maxProduct;
    }
}