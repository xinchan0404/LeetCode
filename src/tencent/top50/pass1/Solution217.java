package tencent.top50.pass1;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
