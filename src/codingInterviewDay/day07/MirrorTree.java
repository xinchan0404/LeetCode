package codingInterviewDay.day07;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * @author xinchan
 * @version 1.0.1 2022-01-05
 */
public class MirrorTree {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {4,2,7,1,3,6,9};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 MirrorTree()
         */
        MirrorTree mirrorTree = new MirrorTree();
        Integer[] array1 = new Integer[0];
        CompleteBinaryTree completeBinaryTree1 = new CompleteBinaryTree(array1);
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
//            completeBinaryTree1.root = mirrorTree.mirrorTree(completeBinaryTree.root);
            completeBinaryTree1.root = mirrorTree.mirrorTree1(completeBinaryTree.root);
//            completeBinaryTree1.root = mirrorTree.mirrorTree2(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        completeBinaryTree1.preorder();
    }

    /**
     * 二叉树的镜像 - 深度优先遍历、前序遍历、递归
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    /**
     * 二叉树的镜像 - 深度优先遍历、后序遍历、递归
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree1(root.left);
        root.left = mirrorTree1(root.right);
        root.right = left;

        return root;
    }

    /**
     * 二叉树的镜像 - 广度优先遍历、迭代、队列
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        return root;
    }
}
