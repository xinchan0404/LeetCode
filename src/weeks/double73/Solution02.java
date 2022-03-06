package weeks.double73;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-05
 */
public class Solution02 {
    /**
     * 5217. 将杂乱无章的数字排序
     * @param mapping
     * @param nums
     * @return
     */
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] numsTmp = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            int consult = nums[i];
            int k = 1;
            while (consult > 0) {
                consult /= 10;
                int remainder = consult % 10;
                num += Math.pow(10, k++) * mapping[remainder];
            }
            numsTmp[i] = num;
            map.put(nums[i], num);
        }
        System.out.println(Arrays.toString(numsTmp));

        int[] newNums = new int[n];
        Arrays.sort(numsTmp);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.get(nums[j]) == numsTmp[i]) {
                    newNums[i] = nums[j];
                    break;
                }
            }
        }

        return newNums;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums ={991,338,38};
        int[] ints = solution02.sortJumbled(mapping, nums);
        System.out.println(Arrays.toString(ints));
    }
}
