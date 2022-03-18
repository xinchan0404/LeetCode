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
        if (B == null || A == null) {
            return false;
        }
        if (isSubStructureRecur(A, B)) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructureRecur(A.right, B);
    }

    public boolean isSubStructureRecur(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSubStructureRecur(A.left, B.left) && isSubStructureRecur(A.right, B.right);
    }
}
