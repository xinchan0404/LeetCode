package offer.I.pass1;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class Offer07 {
    private Map<Integer, Integer> inorder = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            this.inorder.put(i, inorder[i]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        return recur();
    }
    
    private TreeNode recur(TreeNode root, int leftPre, int rightPre, int leftIn, int rightIn) {
        if ()
    }
}
