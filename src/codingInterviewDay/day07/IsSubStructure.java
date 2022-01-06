package codingInterviewDay.day07;

import utils.CompleteBinaryTree;
import utils.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * @author xinchan
 * @version 1.0.1 2022-01-05
 */
public class IsSubStructure {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] arrayA = {3, 4, 5, 1, 2, null, null};
        Integer[] arrayB = {4, 1, null};
        CompleteBinaryTree completeBinaryTreeA = new CompleteBinaryTree(arrayA);
        CompleteBinaryTree completeBinaryTreeB = new CompleteBinaryTree(arrayB);
        completeBinaryTreeA.root = completeBinaryTreeA.fullBinaryTree();
        completeBinaryTreeB.root = completeBinaryTreeB.fullBinaryTree();
        completeBinaryTreeA.preorder();
        completeBinaryTreeB.preorder();

        /*
         * 测试 isSubStructure()
         */
        IsSubStructure isSubStructure = new IsSubStructure();
        boolean isSub = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            isSub = isSubStructure.isSubStructure(completeBinaryTreeA.root, completeBinaryTreeB.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(isSub);
    }

    /**
     * 树的子结构 - 深度优先遍历、递归
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return isSubStructureRecur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 两个树是否具有子结构关系 - 深度优先遍历、递归
     * @param A
     * @param B
     * @return
     */
    private boolean isSubStructureRecur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }

        return isSubStructureRecur(A.left, B.left) && isSubStructureRecur(A.right, B.right);
    }

    /**
     * 树的子结构 - 广度优先遍历、迭代
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        return false;
    }
}
