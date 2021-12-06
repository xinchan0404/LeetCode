package dailyTopic;

import java.util.Arrays;

/**
 * 1816. 截断句子
 * 提示：
 * 1 <= s.length <= 500
 * k 的取值范围是 [1, s 中单词的数目]
 * s 仅由大小写英文字母和空格组成
 * s 中的单词之间由单个空格隔开
 * 不存在前导或尾随空格
 *
 * @author xinchan
 * @version 1.0.1 2021-12-06
 */
public class Daily1206 {
    public static void main(String[] args) {
        /*
         * 测试 truncateSentence 方法
         */
        String s = "What is the solution to this problem";
        int k = 4;

        String truncateSentence = truncateSentence1(s, k);

        System.out.println(truncateSentence);
    }

    /**
     * 根据指定位置截断句子 - StringBuilder
     *
     * @param s
     * @param k
     * @return
     */
    public static String truncateSentence(String s, int k) {
        StringBuilder truncateSentence = new StringBuilder();
        String[] stringArray = s.split(" ");

        for (int i = 0; i < k - 1; i++) {
            truncateSentence.append(stringArray[i]);
            truncateSentence.append(" ");
        }
        truncateSentence.append(stringArray[k - 1]);
        return truncateSentence.toString();
    }

    /**
     * 根据指定位置截断句子 - 字符串拼接（太慢了）
     *
     * @param s
     * @param k
     * @return
     */
    public static String truncateSentence1(String s, int k) {
        String truncateSentence = "";
        String[] stringArray = s.split(" ");

        for (int i = 0; i < k - 1; i++) {
            truncateSentence += stringArray[i] + " ";
        }
        truncateSentence += stringArray[k - 1];
        return truncateSentence.toString();
    }

    /**
     * 根据指定位置截断句子 - substring
     *
     * @param s
     * @param k
     * @return
     */
    public static String truncateSentence2(String s, int k) {
        int count = 0;
        int end = 0;

        for (int i = 1; i < s.length(); i++) {
            if ()
        }
    }
}
