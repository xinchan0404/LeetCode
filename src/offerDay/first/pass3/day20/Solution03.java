package offerDay.first.pass3.day20;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @author xinchan
 * @version 1.0.1 2022-03-21
 */
public class Solution03 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return false;
        }
        int root = postorder[right];
        int leftPos = left;
        int rightPos = 0;
        while (postorder[leftPos] < root) {
            leftPos++;
        }
        rightPos = leftPos;
        while (postorder[rightPos] > root) {
            rightPos++;
        }
        return rightPos == right && recur(postorder, left, leftPos - 1) && recur(postorder, leftPos, rightPos - 1);
    }
}
