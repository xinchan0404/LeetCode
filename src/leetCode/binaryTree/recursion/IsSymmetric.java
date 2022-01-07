package leetCode.binaryTree.recursion;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 28. 对称的二叉树
 *
 * @author xinchan
 * @version 1.0.1 2022-01-07
 */
public class IsSymmetric {
    /**
     * 对称的二叉树 - 镜像、深度优先遍历、递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricRecur(root, root);
    }

    /**
     * 对称的二叉树 - 递归
     * @param root1
     * @param root2
     */
    private boolean isSymmetricRecur(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 == null || root2 == null) || root1.val != root2.val) {
            return false;
        }

        return isSymmetricRecur(root1.left, root2.right) && isSymmetricRecur(root1.right, root2.left);
    }

    /**
     * 对称的二叉树 - 镜像、广度优先遍历、迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i += 2) {
                TreeNode node1 = deque.remove();
                TreeNode node2 = deque.remove();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null || node1.val != node2.val) {
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

    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
//        Integer[] array = {1, 2, 2, null, 3, null, 3};
//        Integer[] array = {};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 isSymmetric()
         */
        IsSymmetric isSymmetric = new IsSymmetric();
        boolean isSymmetricTree = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            isSymmetricTree = isSymmetric.isSymmetric(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(isSymmetricTree);
    }
}
