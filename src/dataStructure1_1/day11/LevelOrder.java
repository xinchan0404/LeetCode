package dataStructure1_1.day11;

import dataStructure1_1.utils.CompleteBinaryTree;
import dataStructure1_1.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * @author xinchan
 * @version 1.0.1 2021-12-09
 */
public class LevelOrder {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {3, 9, 20, null, null, 15, 7};
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();

        /*
         * 测试 levelOrder()
         */
        List<List<Integer>> levels = levelOrder(completeBinaryTree.root);
        System.out.println(levels);
    }

    /**
     * 二叉树的层序遍历 - 队列
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null) {
            return levels;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < dequeSize; i++) {
                TreeNode node = deque.remove();

                level.add(node.val);

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }
}
