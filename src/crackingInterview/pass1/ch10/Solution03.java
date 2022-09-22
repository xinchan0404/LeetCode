package crackingInterview.pass1.ch10;

/**
 * 面试题 10.03. 搜索旋转数组
 * @author xinchan
 * @version 1.0.1 2022-09-21
 */
public class Solution03 {
    public int search(int[] arr, int target) {
        int right = arr.length - 1;
        int pivot = binarySearch(arr, 0, right);
        int ans = -1;
        if (target >= arr[0]) {
            ans = binarySearch(arr, 0, pivot - 1, target);
        } else {
            ans = binarySearch(arr, pivot, right, target);
        }
        return ans;
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                if (mid - 1 >= 0 && arr[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr, int left, int right) {
        while (arr[left] == arr[right]) {
            left++;
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution03 s = new Solution03();
//        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] arr = {1, 1, 1, 1, 1, 2, 1, 1, 1};
        int i = s.binarySearch(arr, 0, arr.length - 1);
        System.out.println(i);
        int search = s.search(arr, 2);
        System.out.println(search);
    }
}
