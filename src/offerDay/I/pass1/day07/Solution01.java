package offerDay.I.pass1.day07;

import utils.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 * @author xinchan
 * @version 1.0.1 2022-￥06-29
 */
public class Solution01 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isSubStructure(A.left, B) && isSubStructure(A.right, B);
    }
}
