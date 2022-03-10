package codingInterviewDay_2.day20;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-06
 */
public class Solution01 {
    private Map<Integer, Integer> map = new HashMap<>();
    /**
     * 剑指 Offer 07. 重建二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeRecur(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 递归构建二叉树
     * @param preorder 前序遍历结果
     * @param inorder 中序遍历结果
     * @param preorderLeft 前序遍历左边界
     * @param preorderRight 前序遍历右边界
     * @param inorderLeft 中序遍历左边界
     * @param inorderRight 中序遍历右边界
     * @return
     */
    private TreeNode buildTreeRecur(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        int preorderRoot = preorderLeft;  // 前序遍历中根节点的位置
        int inorderRoot = map.get(preorder[preorderRoot]);  // 中序遍历中根节点的位置
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int subLeftTreeLen = inorderRoot - inorderLeft;
        root.left = buildTreeRecur(preorder, inorder, preorderLeft + 1, preorderLeft + subLeftTreeLen, inorderLeft, inorderRoot - 1);
        root.right = buildTreeRecur(preorder, inorder, preorderLeft + subLeftTreeLen + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }
}
