package offerDay.I.pass1.day20;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-06
 */
public class Solution03 {
    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        return verifyPostorderRecur(postorder, 0, n - 1);
    }

    private boolean verifyPostorderRecur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = postorder[right];
        int leftPos = left;  // 左子树的右边界 - 1
        while (postorder[leftPos] < root) {
            leftPos++;
        }
        int rightPos = leftPos; // 右子树的左边界
        while (postorder[rightPos] > root) {
            rightPos++;
        }
        return rightPos == right && verifyPostorderRecur(postorder, left, leftPos - 1) && verifyPostorderRecur(postorder, rightPos, right - 1);
    }
}
