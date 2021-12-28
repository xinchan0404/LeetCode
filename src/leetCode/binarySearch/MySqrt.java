package leetCode.binarySearch;

/**
 * 剑指 Offer II 072. 求平方根
 * 提示:
 * 0 <= x <= 231 - 1
 *
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class MySqrt {
    public static void main(String[] args) {
        /*
         * 测试 mySqrt()
         */
        MySqrt mySqrt = new MySqrt();
        int x = 100000000;
        int pos = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pos = mySqrt.mySqrt(x);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(pos);
    }

    /**
     * 求平方根 - 二分查找
     * 注意整数溢出
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (x / mid < mid) {
                right = mid - 1;
            } else if (x / mid > mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}
