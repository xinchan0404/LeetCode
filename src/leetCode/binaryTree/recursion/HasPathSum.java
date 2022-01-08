package leetCode.binaryTree.recursion;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 112. 路径总和
 *
 * @author xinchan
 * @version 1.0.1 2022-01-08
 */
public class HasPathSum {
    /**
     * 路径总和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return hasPathSumRecur(root, 0, targetSum);
    }

    private boolean hasPathSumRecur(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        } else {
            sum += root.val;
        }

        if (root.left == null && root.right == null && sum == targetSum) {
            return true;
        }

        return hasPathSumRecur(root.left, sum, targetSum) || hasPathSumRecur(root.right, sum, targetSum);
    }

    /**
     * 路径总和 - 广度优先遍历
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> dequeNode = new LinkedList<>();
        Deque<Integer> dequeVal = new ArrayDeque<>();
        dequeNode.add(root);
        dequeVal.add(root.val);
        while (!dequeNode.isEmpty()) {
            int size = dequeNode.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dequeNode.remove();
                int sum = dequeVal.remove();
                if (node.left == null && node.right == null && sum == targetSum) {
                    return true;
                }
                if (node.left != null) {
                    dequeNode.add(node.left);
                    dequeVal.add(sum + node.left.val);
                }
                if (node.right != null) {
                    dequeNode.add(node.right);
                    dequeVal.add(sum + node.right.val);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 hasPathSum()
         */
        HasPathSum hasPathSum = new HasPathSum();
        int targetSum = 22;
        boolean hasOrNot = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            hasOrNot = hasPathSum.hasPathSum(completeBinaryTree.root, targetSum);  // 48 ms
            hasOrNot = hasPathSum.hasPathSum1(completeBinaryTree.root, targetSum);  // 275 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(hasOrNot);
    }
}
