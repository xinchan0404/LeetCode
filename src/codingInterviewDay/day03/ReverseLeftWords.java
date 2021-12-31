package codingInterviewDay.day03;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 限制：
 * 1 <= k < s.length <= 10000
 *
 * @author xinchan
 * @version 1.0.1 2021-12-31
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        /*
         * 测试 reverseLeftWords()
         */
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        String s = "abcdefg";
        int k = 2;
        String reversedS = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            reversedS = reverseLeftWords.reverseLeftWords(s, k);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(reversedS);
    }

    /**
     * 左旋转字符串 - 字符串拼接 +
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        String left = s.substring(0, n);
        String right = s.substring(n, length);
        return right + left;
    }

    /**
     * 左旋转字符串 - 字符串拼接 StringBuilder
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords1(String s, int n) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < len; i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}
