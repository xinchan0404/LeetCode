package tencent.top50.pass2;

import org.omg.CORBA.INTERNAL;

/**
 * 11. 盛最多水的容器
 * @author xinchan
 * @version 1.0.1 2022-￥05-22
 */
public class LC10 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
