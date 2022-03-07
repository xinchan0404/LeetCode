package codingInterviewDay_2.day07;

import utils.TreeNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
public class Solution01 {
    /**
     * 剑指 Offer 26. 树的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSubStructureRecur(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return isSubStructureRecur(root1.left, root2.left) && isSubStructureRecur(root1.right, root2.right);
    }
}
