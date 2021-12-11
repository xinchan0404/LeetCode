package dataStructure1_1.day11;

import dataStructure1_1.utils.CompleteBinaryTree;
import dataStructure1_1.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
        Integer[] array = {1, 2, 3, 4, null, null, 7};
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();

        /*
         * 测试 maxDepth()
         */
        int maxDepth = maxDepth1(completeBinaryTree.root);
        System.out.println(maxDepth);
    }

    /**
     * 二叉树的最大深度 - 深度优先搜索（DFS）
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    /**
     * 二叉树的最大深度 - 广度优先搜索（BFS）
     *
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        int maxDepth = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                TreeNode node = deque.remove();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            maxDepth++;
        }

        return maxDepth;
    }
}
