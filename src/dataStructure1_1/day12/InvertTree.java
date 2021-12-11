package dataStructure1_1.day12;

import dataStructure1_1.utils.CompleteBinaryTree;
import dataStructure1_1.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 *
 * @author xinchan
 * @version 1.0.1 2021-12-10
 */
public class InvertTree {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        Integer[] array = {1, 2, 3, 4, null, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();

        /*
         * 测试 invertTree()
         */
        completeBinaryTree.root = invertTree1(completeBinaryTree.root);
        completeBinaryTree.preOrder();
    }

    /**
     * 翻转二叉树 - DFS
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmpLeft = invertTree(root.right);
        TreeNode tmpRight = invertTree(root.left);
        root.left = tmpLeft;
        root.right = tmpRight;

        return root;
    }

    /**
     * 翻转二叉树 - BFS
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            int stackSize = deque.size();
            for (int i = 0; i < stackSize; i++) {
                TreeNode node = deque.pop();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }

                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
        }

        return root;
    }
}
