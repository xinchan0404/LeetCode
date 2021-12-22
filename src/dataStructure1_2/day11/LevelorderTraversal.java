package dataStructure1_2.day11;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * @author xinchan
 * @version 1.0.1 2021-12-22
 */
public class LevelorderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();

        /*
         * 测试 levelOrder()
         */
        LevelorderTraversal levelorderTraversal = new LevelorderTraversal();
        List<List<Integer>> levels = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            levels = levelorderTraversal.levelOrder(completeBinaryTree.root);  // 1000000: 188 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(levels);
    }

    /**
     * 二叉树的层序遍历 - 队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> levels = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.remove();

                level.add(cur.val);

                if (cur.left != null) {
                    deque.add(cur.left);
                }
                if (cur.right != null) {
                    deque.add(cur.right);
                }
            }
            levels.add(level);
        }

        return levels;
    }
}
