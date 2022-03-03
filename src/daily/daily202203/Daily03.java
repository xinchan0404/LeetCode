package daily.daily202203;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Daily03 {
    /**
     * 258. 各位相加
     * @param num
     * @return
     */
    public int addDigits(int num) {
        int newNum = num;
        while (newNum >= 10) {
            String s = String.valueOf(num);
            int n = s.length();
            newNum = 0;
            for (int i = 0; i < n; i++) {
                newNum += s.charAt(i) - '0';
            }
        }
        return newNum;
    }
}
