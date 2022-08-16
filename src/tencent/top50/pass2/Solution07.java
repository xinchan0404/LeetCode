package tencent.top50.pass2;

/**
 * 11. 盛最多水的容器
 * @author xinchan
 * @version 1.0.1 2022-08-17
 */
public class Solution07 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0, cur = 0;
        while (left < right) {
            cur = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, cur);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
