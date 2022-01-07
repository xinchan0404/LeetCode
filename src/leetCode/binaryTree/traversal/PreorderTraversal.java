package leetCode.binaryTree.traversal;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 *
 * @author xinchan
 * @version 1.0.1 2022-01-07
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, null, 5, 6, null};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 preorderTraversal()
         */
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> list = new ArrayList<>();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list = preorderTraversal.preorderTraversal(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(list);
    }

    /**
     * 二叉树的前序遍历 - 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preorder(root, list);

        return list;
    }

    /**
     * 二叉树的前序遍历 - 递归
     *
     * @param root
     */
    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        } else {
            list.add(root.val);
        }

        preorder(root.left, list);
        preorder(root.right, list);
    }

    /**
     * 二叉树的前序遍历 - 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }

        return list;
    }
}
