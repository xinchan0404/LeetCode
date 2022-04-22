package tencent.top50.pass1;

/**
 * 11. 盛最多水的容器
 * @author xinchan
 * @version 1.0.1 2022-03-30
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;
        int area;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
