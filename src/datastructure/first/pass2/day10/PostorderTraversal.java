package datastructure.first.pass2.day10;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author xinchan
 * @version 1.0.1 2021-12-21
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
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
//            list = postorderTraversal.postorderTraversal(completeBinaryTree.root);  // 1000000: 60 ms
            list = postorderTraversal.postorderTraversal1(completeBinaryTree.root);  // 1000000: 91 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(list);
    }

    /**
     * 二叉树的后序遍历 - 左右根
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        postorder(root, list);

        return list;
    }

    /**
     * 后序遍历方法
     *
     * @param root
     * @param list
     */
    public void postorder(TreeNode root, List<Integer> list) {
        /*
         * 左子树：如果左子节点非空，递归左子树
         */
        if (root.left != null) {
            postorder(root.left, list);
        }

        /*
         * 右子树：如果右子节点非空，递归右子树
         */
        if (root.right != null) {
            postorder(root.right, list);
        }

        /*
         * 根节点：相关操作
         */
        list.add(root.val);
    }

    /**
     * 二叉树的后序遍历 - 迭代
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
