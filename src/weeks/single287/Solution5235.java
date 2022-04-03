package weeks.single287;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-03
 */
public class Solution5235 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Map<Integer, Integer> winner = new TreeMap<>();
        Map<Integer, Integer> loser = new TreeMap<>();
        for (int[] match : matches) {
            winner.put(match[0], winner.getOrDefault(match[0], 0) + 1);
            loser.put(match[1], loser.getOrDefault(match[1], 0) - 1);
        }
        for (Integer integer : winner.keySet()) {
            if (winner.get(integer) > 0 && (!loser.containsKey(integer) || loser.get(integer) == 0)) {
                list1.add(integer);
            }
        }
        for (Integer integer : loser.keySet()) {
            if (loser.get(integer) == -1) {
                list2.add(integer);
            }
        }
        lists.add(list1);
        lists.add(list2);
        return lists;
    }
}
