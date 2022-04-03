package weeks.single287;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-03
 */
public class Solution01 {
    public int convertTime(String current, String correct) {
        int c1 = Integer.parseInt(current.split(":")[0]) * 60 + Integer.parseInt(current.split(":")[1]);
        int c2 = Integer.parseInt(correct.split(":")[0]) * 60 + Integer.parseInt(correct.split(":")[1]);
        int diff = c2 - c1;
        int cnt = 0;
        if (diff >= 60) {
            cnt += diff / 60;
            diff %= 60;
        }
        if (diff >= 15) {
            cnt += diff / 15;
            diff %= 15;
        }
        if (diff >= 5) {
            cnt += diff / 5;
            diff %= 5;
        }
        return cnt + diff;
    }
}
