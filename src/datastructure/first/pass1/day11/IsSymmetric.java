package datastructure.first.pass1.day11;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 *
 * @author xinchan
 * @version 1.0.1 2021-12-09
 */
public class IsSymmetric {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
//        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
//        Integer[] array = {1, 1, 2, 3, 4, 4, 3};
//        Integer[] array = {1, 2, 2, 3, null, 3, null};
        Integer[] array = {1, 2, 2, 3, null, null, 3};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 isSymmetric()
         */
        boolean isSymmetric = isSymmetric(completeBinaryTree.root);
        System.out.println(isSymmetric);
    }

    /**
     * 二叉树是否是对称的 - 广度优先搜索（BFS）、队列
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
        Deque<TreeNode> stack = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize / 2; i++) {
                TreeNode node = deque.remove();
                stack.push(node);
                if (node == null) {
                    continue;
                }
                deque.add(node.left);
                deque.add(node.right);
            }

            for (int i = dequeSize / 2; i < dequeSize; i++) {
                TreeNode node = deque.remove();
                if (stack.peek() == null && node == null) {
                    stack.pop();
                    continue;
                }
                if ((stack.peek() == null || node == null) || (stack.peek().val != node.val)) {
                    return false;
                }
                stack.pop();
                deque.add(node.left);
                deque.add(node.right);
            }
        }

        return true;
    }
}
