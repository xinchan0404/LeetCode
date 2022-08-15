package daily.daily202207;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * @author xinchan
 * @version 1.0.1 2022-07-28
 */
public class Daily28 {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] arrSorted = new int[n];
        System.arraycopy(arr, 0, arrSorted, 0, n);
        Arrays.sort(arrSorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 1; i < n; i++) {
            if (!map.containsKey(arrSorted[i])) {
                map.put(arrSorted[i], j++);
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
