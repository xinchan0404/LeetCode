package daily.daily202112;

/**
 * 1446. 连续字符
 * 提示：
 * 1. 1 <= s.length <= 500
 * 2. s 只包含小写英文字母。
 *
 * @author xinchan
 * @version 1.0.1 2021-12-01
 */
public class Daily1201 {
    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";

        int maxPower = 0;

        maxPower = maxPower(s);

        System.out.println(maxPower);
    }

    /**
     * 只包含一种字符的最长非空子字符串的长度
     * @param s
     * @return
     */
    public static int maxPower(String s) {
        int count = 1;
        int maxPower = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            maxPower = Math.max(maxPower, count);
        }

        return maxPower;
    }
}
