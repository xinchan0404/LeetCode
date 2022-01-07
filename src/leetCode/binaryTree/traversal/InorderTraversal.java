package leetCode.binaryTree.traversal;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-07
 */
public class InorderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, null, 5, 6, null};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.inorder();

        /*
         * 测试 inorderTraversal()
         */
        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> list = new ArrayList<>();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            list = inorderTraversal.inorderTraversal(completeBinaryTree.root);
            list = inorderTraversal.inorderTraversal1(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(list);
    }

    /**
     * 二叉树的中序遍历 - 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorder(root, list);

        return list;
    }

    /**
     * 二叉树的中序遍历 - 递归
     *
     * @param root
     * @param list
     */
    private void inorder(TreeNode root, List<Integer> list) {
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
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}
