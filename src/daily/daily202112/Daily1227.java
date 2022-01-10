package daily.daily202112;

import java.util.Arrays;

/**
 * 825. 适龄的朋友
 * 提示：
 * n == ages.length
 * 1 <= n <= 2 * 104
 * 1 <= ages[i] <= 120
 *
 * @author xinchan
 * @version 1.0.1 2021-12-27
 */
public class Daily1227 {
    public static void main(String[] args) {
        /*
         * 测试 numFriendRequests()
         */
        Daily1227 daily1127 = new Daily1227();
//        int[] ages = {20, 30, 100, 110, 120};
//        int[] ages = {16,17,18};
        int[] ages = {16, 16, 16, 17, 18};
        int numFriend = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
//            numFriend = daily1127.numFriendRequests(ages);
            numFriend = daily1127.numFriendRequests1(ages);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(numFriend);
    }

    /**
     * 适龄的朋友 - 排序、二分查找
     *
     * @param ages
     * @return
     */
    public int numFriendRequests1(int[] ages) {
        Arrays.sort(ages);

        int cnt = 0;
        int len = ages.length;
        for (int i = 0; i < len - 1; i++) {
            if (ages[i] > 14) {
                cnt += binarySearch(ages, i, len - 1, ages[i], len) - binarySearch(ages, 0, i - 1, ages[i] / 2 + 7, len) - 1;
            }
        }

        return cnt;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int left, int right, int target, int len) {
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid != len - 1 || nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        }

        return right;
    }
}
