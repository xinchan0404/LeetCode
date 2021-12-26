package leetCode.stringMatching;

/**
 * 28. 实现 strStr()
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author xinchan
 * @version 1.0.1 2021-12-26
 */
public class StrStr {
    public static void main(String[] args) {
        /*
         * 测试 strStr()
         */
        StrStr strStr = new StrStr();
        String haystack = "";
        String needle = "";
        int pos = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos = strStr.strStr(haystack, needle);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(pos);
    }

    /**
     * 实现 strStr()
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

    }
}
