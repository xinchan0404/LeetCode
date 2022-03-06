package daily.daily202203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-06
 */
public class Daily06 {
    /**
     * 2100. 适合打劫银行的日子 - 动态规划
     * @param security
     * @param time
     * @return
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> list = new ArrayList<>();
        if ((n % 2 == 0 && time >= n / 2) || (n % 2 != 0 && time > n / 2)) {
            return list;
        }

        int[] left = new int[n];  // 第 i 天前连续非递增的天数
        int[] right = new int[n];  // 第 i 天后连续非递减的天数
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }

        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Daily06 daily06 = new Daily06();
        int[] security = {5,3,3,3,5,6,2};
        int time = 2;
        List<Integer> list = daily06.goodDaysToRobBank(security, time);
        System.out.println(list);
    }
}
