package codingInterviewDay.day06;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * @author xinchan
 * @version 1.0.1 2022-01-04
 */
public class LevelOrder2 {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 levelOrder()
         */
        LevelOrder2 levelOrder = new LevelOrder2();
        List<List<Integer>> levels = new ArrayList<>();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            levels = levelOrder.levelOrder(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(levels);
    }

    /**
     * 层序遍历 - 迭代、队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
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
