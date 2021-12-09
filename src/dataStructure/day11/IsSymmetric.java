package dataStructure.day11;

import dataStructure.utils.CompleteBinaryTree;
import dataStructure.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-09
 */
public class IsSymmetric {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();

        /*
         * 测试 isSymmetric()
         */

    }

    /**
     * 二叉树是否是对称的 - 广度优先搜索（BFS）
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                TreeNode node = deque.remove();
                deque.add(node.left);
                deque.add(node.right);
            }
        }
        
        return true;
    }
}
