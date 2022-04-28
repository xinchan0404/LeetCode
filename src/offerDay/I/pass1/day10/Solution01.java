package offerDay.I.pass1.day10;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-02
 */
public class Solution01 {
    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = Integer.toString(num);
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = Integer.parseInt(s.substring(0, 2)) <= 25 ? 2 : 1;
        int sum = second;
        for (int i = 2; i < n; i++) {
            int j = Integer.parseInt(s.substring(i - 1, i + 1));
            if (j <= 25 && j >= 10) {
                sum += first;
            }
            sum += second;
            first = second;
            second = sum;
        }
        return sum;
    }
}
