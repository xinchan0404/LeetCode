package crackingInterview.pass1.ch10;

/**
 * 面试题 10.05. 稀疏数组搜索
 * @author xinchan
 * @version 1.0.1 2022-09-22
 */
public class Solution05 {
    public int findString(String[] words, String s) {
        int n = words.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (words[mid].equals("")) {
                if (words[right].equals(s)) {
                    return right;
                } else {
                    right--;
                }
            }
            if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
