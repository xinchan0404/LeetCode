package dataStructure1_1.day10;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author xinchan
 * @version 1.0.1 2021-12-08
 */
public class PreOrderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, null, null, 7};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        List<Integer> list;
        list = preorderTraversal2(completeBinaryTree.root);
        System.out.println(list);
    }

    /**
     * 二叉树的前序遍历 - 递归 + addAll()
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.add(root.val);

        if (root.left != null) {
            list.addAll(preorderTraversal(root.left));
        }

        if (root.right != null) {
            list.addAll(preorderTraversal(root.right));
        }

        return list;
    }

    /**
     * 二叉树的前序遍历 - 官方题解
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    /**
     * 二叉树的前序遍历 - 递归函数
     *
     * @param root
     * @param list
     */
    public static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    /**
     * 二叉树的前序遍历 - 迭代
     *
     * @param root
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        TreeNode tmp = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || tmp != null) {
            while (tmp != null) {
                list.add(tmp.val);
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.poll();
            tmp = tmp.right;
        }

        return list;
    }
}
