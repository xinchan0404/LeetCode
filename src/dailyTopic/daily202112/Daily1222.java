package dailyTopic.daily202112;

/**
 * 686. 重复叠加字符串匹配
 * 提示：
 * 1 <= a.length <= 104
 * 1 <= b.length <= 104
 * a 和 b 由小写英文字母组成
 *
 * @author xinchan
 * @version 1.0.1 2021-12-21
 */
public class Daily1222 {
    public static void main(String[] args) {
        /*
         * 测试 repeatedStringMatch()
         */
        Daily1222 daily1222 = new Daily1222();
//        String a = "abcd";
//        String b = "cdabcdab";
//        String a = "a";
//        String b = "aa";
//        String a = "abc";
//        String b = "abcabcab";
        String a = "aab";
        String b = "aabaabaaba";
        int repeatedNums = 0;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            repeatedNums = daily1222.repeatedStringMatch(a, b);  // 1000000: 75 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(repeatedNums);
    }

    /**
     * 重复叠加字符串匹配 - 在 a 的重复字符串中寻找 b
     *
     * @param a
     * @param b
     * @return
     */
    public int repeatedStringMatch(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if (aLen == bLen && a.equals(b)) {
            return 1;
        } else if (aLen > bLen && a.contains(b)) {
            return 1;
        } else {
            String repeatedA = a.repeat(bLen / aLen + 2);
            int repeatedALen = repeatedA.length();
            for (int i = 0; i < repeatedALen - bLen + 1; i++) {
                if (repeatedA.substring(i, i + bLen).equals(b)) {
                    return bLen / aLen + 2 - ((repeatedALen - bLen - i) / aLen);
                }
            }
        }

        return -1;
    }

    /**
     * 重复叠加字符串匹配 - 在 b 中寻找 a 出现的次数
     *
     * @param a
     * @param b
     * @return
     */
    public int repeatedStringMatch1(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if (aLen == bLen && a.equals(b)) {
            return 1;
        } else if (aLen > bLen && a.contains(b)) {
            return 1;
        } else {
            int repeats = 0;
            int i = 0;
            while (i < bLen - aLen + 1) {
                if (b.substring(i, i + aLen).equals(a)) {
                    repeats++;
                    i += aLen;
                }
            }
        }

        return -1;
    }
}
