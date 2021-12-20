package dailyTopic;

import java.util.Arrays;

/**
 * 475. 供暖器
 * 提示：
 * 1 <= houses.length, heaters.length <= 3 * 10^4
 * 1 <= houses[i], heaters[i] <= 10^9
 *
 * @author xinchan
 * @version 1.0.1 2021-12-20
 */
public class Daily1220 {
    public static void main(String[] args) {
        /*
         * 测试 findRadius()
         */
        Daily1220 daily1220 = new Daily1220();
        int[] houses = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] heaters = {2, 4, 7};
        int radius = 0;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            radius = daily1220.findRadius(houses, heaters);  // 1000000: 23 ms
            radius = daily1220.findRadius1(houses, heaters);  // 1000000: 33 ms，对于 heaters 数组长度特别大，二分查找效果更加
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(radius);
    }

    /**
     * 供暖器 - 排序、暴力遍历
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int heatersLength = heaters.length;
        int radius = Integer.MIN_VALUE;
        for (int house : houses) {
            int curRadius;
            if (house <= heaters[0]) {
                curRadius = heaters[0] - house;
                radius = Math.max(radius, curRadius);
                continue;
            } else if (house >= heaters[heatersLength - 1]) {
                curRadius = house - heaters[heatersLength - 1];
                radius = Math.max(radius, curRadius);
                continue;
            }
            int minHouseRadius = Integer.MAX_VALUE;
            for (int heater : heaters) {
                if (house == heater) {
                    minHouseRadius = 0;
                    break;
                }
                int houseRadius = Math.abs(house - heater);
                if (minHouseRadius > houseRadius) {
                    minHouseRadius = houseRadius;
                }
            }
            radius = Math.max(radius, minHouseRadius);
        }

        return radius;
    }

    /**
     * 供暖器的最小加热半径 - 排序、二分查找
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j > heaters.length - 1 ? Integer.MAX_VALUE : heaters[j] - house;
            radius = Math.max(radius, Math.min(leftDistance, rightDistance));
        }

        return radius;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[left]) {
            return -1;
        }
        if (target > nums[right]) {
            return nums.length - 1;
        }

        while (left < right) {
            int mid = (right - left + 1) / 2 + left;

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 保证返回的位置数据严格小于等于 target
                left = mid;
            }
        }

        return left;
    }
}
