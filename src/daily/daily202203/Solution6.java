package daily.daily202203;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-01
 */
public class Solution6 {
    /**
     * Z 字形变换
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < numRows; i++) {
            int j = i;
            int l = 2 * (numRows - 1) - 2 * i;
            int r = 2 * i;
            while (j < n) {
                stringBuilder.append(s.charAt(j));
                if (l == 0 || r == 0) {
                    j += l + r;
                } else {
                    j += (cnt % 2 == 0 ? l : r);
                }
                cnt++;
            }
            cnt = 0;
        }
        return stringBuilder.toString();
    }
}
