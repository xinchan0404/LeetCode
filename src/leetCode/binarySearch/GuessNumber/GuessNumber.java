package leetCode.binarySearch.GuessNumber;

/**
 * 374. 猜数字大小
 * 提示：
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 *
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class GuessNumber extends GuessGame {
    public static void main(String[] args) {
        /*
         * 测试 guessNumber()
         */
        GuessNumber guessNumber = new GuessNumber();
        int n = 10;
        int pick = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pick = guessNumber.guessNumber(n);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(pick);
    }

    /**
     * 猜数字大小 I - 二分查找
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int res = guess(mid);
            if (res == 1) {
                left = mid + 1;
            } else if (res == -1) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
