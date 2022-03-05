package daily.daily202203;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-05
 */
public class Daily05 {
    /**
     * 521. 最长特殊序列 Ⅰ
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }
}
