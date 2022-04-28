package offerDay.I.pass1.day16;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class Solution01 {
    /**
     * 剑指 Offer 45. 把数组排成最小的数
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    /**
     * 剑指 Offer 45. 把数组排成最小的数
     * @param nums
     * @return
     */
    public String minNumber1(int[] nums) {
        int n = nums.length;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        quickSort(strings, 0, n - 1);
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    private void quickSort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partition(strings, left, right);
        quickSort(strings, left, mid - 1);
        quickSort(strings, mid + 1, right);
    }

    private int partition(String[] strings, int left, int right) {
        int i = left;
        int j = right;
        String pivot = strings[(i + j) >>> 1];
        while (i < j) {
            while ((strings[i] + pivot).compareTo(pivot + strings[i]) < 0) {
                i++;
            }
            while ((strings[j] + pivot).compareTo(pivot + strings[j]) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(strings, i, j);
            if ((strings[i] + pivot).compareTo(pivot + strings[i]) == 0) {
                j--;
            }
            if ((strings[j] + pivot).compareTo(pivot + strings[j]) == 0) {
                i++;
            }
        }
        return j;
    }

    private void swap(String[] strings, int i, int j) {
        String tmp = strings[i];
        strings[i] = strings[j];
        strings[j] = tmp;
    }
}
