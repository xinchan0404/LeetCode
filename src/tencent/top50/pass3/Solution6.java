package tencent.top50.pass3;

/**
 * 11. 盛最多水的容器
 * @author xinchan
 * @version 1.0.1 2023-02-21
 */
public class Solution6 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
