package codingInterviewDay.day06;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-05
 */
public class LevelOrder3 {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {3, 9, 20, 4, 5, 15, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 levelOrder()
         */
        LevelOrder3 levelOrder = new LevelOrder3();
        List<List<Integer>> levels = new ArrayList<>();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            levels = levelOrder.levelOrder(completeBinaryTree.root);  // 201 ms
            levels = levelOrder.levelOrder1(completeBinaryTree.root);  // 239 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(levels);
    }

    /**
     * 层序遍历 - 迭代、队列（Deque）、堆栈（Deque）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        deque.add(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                if (flag) {
                    stack.push(node.val);
                }
                if (!flag) {
                    level.add(node.val);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            if (flag) {
                int stackSize = stack.size();
                for (int i = 0; i < stackSize; i++) {
                    level.add(stack.pop());
                }
            }
            levels.add(level);
            flag = !flag;
        }

        return levels;
    }

    /**
     * 层序遍历 - 迭代、队列（Deque）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int pile = levels.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                if (pile % 2 == 0) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
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
