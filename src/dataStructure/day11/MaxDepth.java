package dataStructure.day11;

import dataStructure.utils.CompleteBinaryTree;
import dataStructure.utils.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author xinchan
 * @version 1.0.1 2021-12-09
 */
public class MaxDepth {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, null, null, 6, 7};
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();
    }

    /**
     * 二叉树的最大深度 - 深度优先遍历
     *
     * @param root
     * @return
     */
//    public static int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int maxDepth = 0;
//        TreeNode tmp = root;
//
//        if (tmp.left != null) {
//            maxDepth(tmp.left);
//        }
//
//        if (tmp.right != null) {
//            maxDepth(tmp.right);
//        }
//    }

    public static void depth(TreeNode root) {

    }
}
