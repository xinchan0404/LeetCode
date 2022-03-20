package offerDay.first.pass3.day16;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Solution01 {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}

class Solution01_ {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public void quickSort(String[] strings) {
        sort(strings, 0, strings.length - 1);
    }

    private void sort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partition(strings, left, right);
        sort(strings, left, mid - 1);
        sort(strings, mid + 1, right);
    }

    private int partition(String[] strings, int left, int right) {
        String pivot = strings[(left + right) >>> 1];
        while (left < right) {
            while ((strings[left] + pivot).compareTo(pivot + strings[left]) < 0) {
                left++;
            }
            while ((strings[right] + pivot).compareTo(pivot + strings[right]) > 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(strings, left, right);
            if ((strings[left] + pivot).compareTo(pivot + strings[left]) == 0) {
                right--;
            }
            if ((strings[right] + pivot).compareTo(pivot + strings[right]) == 0) {
                left++;
            }
        }
        return right;
    }

    private void swap(String[] strings, int left, int right) {
        String tmp = strings[left];
        strings[left] = strings[right];
        strings[right] = tmp;
    }
}
