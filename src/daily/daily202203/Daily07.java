package daily.daily202203;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
public class Daily07 {
    /**
     * 504. 七进制数
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        if (negative) {
            num = -num;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append(num % 7);
            num /= 7;
        }
        stringBuilder.reverse();
        return negative ? "-" + stringBuilder.toString() : stringBuilder.toString();
    }
}
