package daily.daily202203;

import java.util.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-14
 */
public class Daily14 {
    /**
     * 599. 两个列表的最小索引总和
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minIndex = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index = map.get(list2[i]) + i;
                if (index < minIndex) {
                    ans.clear();
                    ans.add(list2[i]);
                    minIndex = index;
                } else if (minIndex == index) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
