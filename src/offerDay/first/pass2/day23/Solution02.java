package offerDay.first.pass2.day23;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-05
 */
public class Solution02 {
    /**
     * 剑指 Offer 66. 构建乘积数组 - 提取公共计算部分
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int n = a.length;
        int[] b = new int[n];
        b[0] = 1;
        for (int i = 1; i < n; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        int tmp = 1;
        for (int i = 1; i < n; i++) {
            tmp *= a[n - i];
            b[n - i - 1] *= tmp;
        }

        return b;
    }

    /**
     * 剑指 Offer 66. 构建乘积数组 - 动态规划
     *
     * @param a
     * @return
     */
    public int[] constructArr1(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }

        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = 1; i < n; i++) {
            right[n - i - 1] = right[n - i] * a[n - i];
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = left[i] * right[i];
        }

        return b;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int[] a = {1, 2, 3, 4, 5};
        int[] ints = solution02.constructArr1(a);
        System.out.println(Arrays.toString(ints));
    }
}
