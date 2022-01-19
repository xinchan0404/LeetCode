package daily.daily202201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-18
 */
public class Daily0118 {
    /**
     * 539. 最小时间差 -
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String s : timePoints) {
            list.add(Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5)));
        }
        Collections.sort(list);
        int size = list.size();
        int minTime = 1440 - list.get(size - 1) + list.get(0);
        for (int i = 0; i < size - 1; i++) {
            int diff = list.get(i + 1) - list.get(i);
            if (diff == 0) {
                return 0;
            } else if (diff < minTime){
                minTime = diff;
            }
        }

        return minTime;
    }
}
