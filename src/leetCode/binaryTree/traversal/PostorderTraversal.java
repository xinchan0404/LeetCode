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
public class PostorderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, null, 5, 6, null};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.postorder();

        /*
         * 测试 postorderTraversal()
         */
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        List<Integer> list = new ArrayList<>();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            list = postorderTraversal.postorderTraversal(completeBinaryTree.root);
            list = postorderTraversal.postorderTraversal1(completeBinaryTree.root);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(list);
    }

    /**
     * 二叉树的后序遍历 - 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        postorder(root, list);

        return list;
    }

    /**
     * 二叉树的后序遍历 - 递归
     *
     * @param root
     * @param list
     */
    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    /**
     * 二叉树的后序遍历 - 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null || cur.right == pre) {
                list.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }

        return list;
    }
}
