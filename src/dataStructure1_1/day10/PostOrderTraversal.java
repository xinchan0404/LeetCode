package dataStructure1_1.day10;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-08
 */
public class PostOrderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, null, null, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();

        /*
         * 测试 postorderTraversal()
         */
        List<Integer> list;
        list = postorderTraversal2(completeBinaryTree.root);
        System.out.println(list);
    }

    /**
     * 二叉树的后续遍历，左右根 - 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.left != null) {
            list.addAll(postorderTraversal(root.left));
        }

        if (root.right != null) {
            list.addAll(postorderTraversal(root.right));
        }

        list.add(root.val);

        return list;
    }

    /**
     * 二叉树的后序遍历 - 官方题解
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    /**
     * 二叉树的后序遍历 - 递归函数
     *
     * @param root
     * @param list
     */
    public static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    /**
     * 二叉树的后续遍历 - 迭代
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        TreeNode tmp = root;
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || tmp != null) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            if (tmp.right == null || tmp.right == pre) {
                list.add(tmp.val);
                pre = tmp;
                tmp = null;
            } else {
                stack.push(tmp);
                tmp = tmp.right;
            }
        }

        return list;
    }
}
