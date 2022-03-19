package datastructure.second.pass1.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 提示:
 * 0 <= rowIndex <= 33
 * 进阶：
 * 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 *
 * @author xinchan
 * @version 1.0.1 2021-12-26
 */
public class GetRow {
    public static void main(String[] args) {
        /*
         * 测试 getRow()
         */
        GetRow getRow = new GetRow();
        int rowIndex = 30;
        List<Integer> list = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            list = getRow.getRow(rowIndex);  // 1000000: 455 ms
            list = getRow.getRow1(rowIndex);  // 1000000: 236 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(list);
    }

    /**
     * 杨辉三角 II - 计算二项式系数，左右对称
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            if (i == 0 || i == rowIndex) {
                list.add(1);
                continue;
            }
            if (i <= rowIndex / 2) {
                list.add(binomialCoefficient(i, rowIndex));
            } else if (i > rowIndex / 2) {
                list.add(list.get(rowIndex - i));
            }
        }

        return list;
    }

    /**
     * 计算二项式系数
     *
     * @param k
     * @param n
     * @return
     */
    private int binomialCoefficient(int k, int n) {
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);
        }

        return (int) res;
    }

    /**
     * 杨辉三角 II - 线性递推
     *
     * @return
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 1; i < rowIndex + 1; i++) {
            list.add((int) ((long) list.get(i - 1) * (rowIndex - i + 1) / i));
        }

        return list;
    }
}
