package dataStructure1_2.day11;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 104. 二叉树的最大深度
 *
 * @author xinchan
 * @version 1.0.1 2021-12-22
 */
public class MaxDepth {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 maxDepth()
         */
        MaxDepth maxDepth = new MaxDepth();
        int depth = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            depth = maxDepth.maxDepth(completeBinaryTree.root);  // 1000000: 16 ms
            depth = maxDepth.maxDepth1(completeBinaryTree.root);  // 1000000: 63 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(depth);
    }

    /**
     * 二叉树的最大深度 - DFS
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    /**
     * 二叉树的最大深度 - BFS
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        int maxDepth = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            maxDepth++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.remove();
                if (cur.left != null) {
                    deque.add(cur.left);
                }
                if (cur.right != null) {
                    deque.add(cur.right);
                }
            }
        }

        return maxDepth;
    }
}
