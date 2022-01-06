package codingInterviewDay.day06;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * @author xinchan
 * @version 1.0.1 2022-01-04
 */
public class LevelOrder1 {
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
        LevelOrder1 levelOrder = new LevelOrder1();
        int[] levels = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            levels = levelOrder.levelOrder(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(Arrays.toString(levels));
    }

    /**
     * 层序遍历 - 迭代、队列
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> arrayList = new ArrayList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                arrayList.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        int size = arrayList.size();
        int[] levels = new int[size];
        for (int i = 0; i < size; i++) {
            levels[i] = arrayList.get(i);
        }

        return levels;
    }
}
