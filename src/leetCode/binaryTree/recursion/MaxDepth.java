package leetCode.binaryTree.recursion;

import utils.CompleteBinaryTree;
import utils.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author xinchan
 * @version 1.0.1 2022-01-07
 */
public class MaxDepth {
    /*
     * instance field
     */
    private int maxDepth;

    /*
     * constructor
     */
    public MaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    /**
     * 二叉树的最大深度 - 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root != null) {
            maxDepthRecur(root, 1);
        }

        return maxDepth;
    }

    /**
     * 二叉树的最大深度 - 递归
     *
     * @param root
     * @param depth
     */
    private void maxDepthRecur(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }

        maxDepthRecur(root.left, depth + 1);
        maxDepthRecur(root.right, depth + 1);
    }

    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
//        Integer[] array = {3, 9, 28, null, null, 15, 7};
        Integer[] array = {1, null, 2};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 maxDepth()
         */
        MaxDepth maxDepth = new MaxDepth(0);
        int max = -1;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            max = maxDepth.maxDepth(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(max);
    }
}
