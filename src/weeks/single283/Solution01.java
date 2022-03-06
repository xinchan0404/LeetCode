package weeks.single283;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-06
 */
public class Solution01 {
    /**
     * 6016. Excel 表中某个范围内的单元格
     * @param s
     * @return
     */
    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        char c1 = s.charAt(0);
        char c2 = s.charAt(3);
        int r1 = Integer.parseInt(s.substring(1, 2));
        int r2 = Integer.parseInt(s.substring(4, 5));

        for (char i = c1; i <= c2; i++) {
            for (int j = r1; j <= r2; j++) {
                list.add(String.valueOf(i) + j);
            }
        }

        return list;
    }
}
