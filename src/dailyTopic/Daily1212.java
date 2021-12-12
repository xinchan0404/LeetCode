package dailyTopic;

/**
 * 709. 转换成小写字母
 * 提示：
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 *
 * @author xinchan
 * @version 1.0.1 2021-12-12
 */
public class Daily1212 {
    public static void main(String[] args) {
        /*
         * 测试 toLowerCase()
         */
        Daily1212 toLowerCase = new Daily1212();

        String s = "Hello World";

        String sLower = toLowerCase.toLowerCase1(s);

        System.out.println(sLower);
    }

    /**
     * 转换成小写字母 - String 标准库方法
     *
     * @param s
     * @return
     */
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    /**
     * 转换成小写字母 - ASCII 转换
     *
     * @param s
     * @return
     */
    public String toLowerCase1(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                stringBuilder.append((char) (ch + 32));
            } else {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }
}
