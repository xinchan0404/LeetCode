package leetCode.binarySearch.firstBadVersion;

/**
 * 278. 第一个错误的版本
 * 提示：
 * 1 <= bad <= n <= 231 - 1
 *
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class FirstBadVersion extends VersionControl {
    public static void main(String[] args) {
        /*
         * 测试 firstBadVersion()
         */
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int n = 10;
        int badVersion = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            badVersion = firstBadVersion.firstBadVersion(n);  // 1000000: 5 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(badVersion);
    }

    /**
     * 第一个错误的版本 - 二分查找
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
