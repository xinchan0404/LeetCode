package datastructure.first.pass2.day11;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 *
 * @author xinchan
 * @version 1.0.1 2021-12-22
 */
public class IsSymmetric {
    public static void main(String[] args) {
        /*
         * 创建对称二叉树
         */
        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 isSymmetric()
         */
        IsSymmetric isSymmetric = new IsSymmetric();
        boolean symmetricOrNot = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            symmetricOrNot = isSymmetric.isSymmetric(completeBinaryTree.root);  // 1000000: 32 ms
            symmetricOrNot = isSymmetric.isSymmetric1(completeBinaryTree.root);  // 1000000: 219 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(symmetricOrNot);
    }

    /**
     * 对称二叉树 - DFS、递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 递归判断二叉树是否为空
     *
     * @param p
     * @param q
     * @return
     */
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 对称二叉树 - BFS、迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode p = deque.remove();
            TreeNode q = deque.remove();
            if (p == null && q == null) {
                continue;
            } else if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            } else {
                deque.add(p.left);
                deque.add(q.right);
                deque.add(p.right);
                deque.add(q.left);
            }
        }

        return true;
    }
}
