package dataStructure.day10;

import dataStructure.utils.CompleteBinaryTree;
import dataStructure.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-08
 */
public class InOrderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, null, null, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preOrder();

        List<Integer> list;
        list = inorderTraversal2(completeBinaryTree.root);
        System.out.println(list);
    }

    /**
     * 二叉树的中序遍历，左根右 - 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }

        list.add(root.val);

        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }

        return list;
    }

    /**
     * 二叉树的中序遍历 - 官方题解
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    /**
     * 二叉树的前序遍历 - 递归函数
     *
     * @param root
     * @param list
     */
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 二叉树的中序遍历 - 迭代
     *
     * @param root
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        TreeNode tmp = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || tmp != null) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            list.add(tmp.val);
            tmp = tmp.right;
        }

        return list;
    }
}
