package codingInterviewDay.day07;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 28. 对称的二叉树
 *
 * @author xinchan
 * @version 1.0.1 2022-01-06
 */
public class IsSymmetric {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
//        Integer[] array = {1, 2, 2, 3, null, 3, null};
        Integer[] array = {1, 2, 2, 3, null, null, 3};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 isSymmetric()
         */
        IsSymmetric isSymmetric = new IsSymmetric();
        boolean isSymmetricOtNot = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            isSymmetricOtNot = isSymmetric.isSymmetric(completeBinaryTree.root);
            isSymmetricOtNot = isSymmetric.isSymmetric1(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(isSymmetricOtNot);
    }

    /**
     * 对称的二叉树 - 镜像、广度优先遍历、迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricRecur(root, root);
    }

    /**
     * 两个二叉树是否镜像对称 - 广度优先遍历、迭代
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSymmetricRecur(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root1);
        deque.add(root2);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i += 2) {
                TreeNode node1 = deque.remove();
                TreeNode node2 = deque.remove();
                if (node1 == null && node2 == null) {
                    continue;
                } else if ((node1 == null || node2 == null) || (node1.val != node2.val)) {
                    return false;
                }
                deque.add(node1.left);
                deque.add(node2.right);
                deque.add(node1.right);
                deque.add(node2.left);
            }
        }

        return true;
    }

    /**
     * 对称的二叉树 - 镜像、深度优先遍历、递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric1Recur(root, root);
    }

    /**
     * 两个二叉树是否镜像对称 - 深度优先遍历、递归
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSymmetric1Recur(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 == null || root2 == null) || (root1.val != root2.val)) {
            return false;
        }

        return isSymmetric1Recur(root1.left, root2.right) && isSymmetric1Recur(root1.right, root2.left);
    }
}
