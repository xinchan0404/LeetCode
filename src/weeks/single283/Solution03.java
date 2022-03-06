package weeks.single283;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-06
 */
public class Solution03 {
    /**
     * @param descriptions
     * @return
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = null;
        for (int[] description : descriptions) {
            if (map.containsKey(description[0])) {
                TreeNode parent = map.get(description[0]);
                TreeNode child = null;
                if (map.containsKey(description[1])) {
                    child = map.get(description[1]);
                } else {
                    child = new TreeNode(description[1]);
                }
                if (description[2] == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                map.put(child.val, child);
            } else if (map.containsKey(description[1])) {
                TreeNode child = map.get(description[1]);
                TreeNode parent = new TreeNode(description[0]);
                if (description[2] == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                map.put(parent.val, parent);
            } else {
                TreeNode parent = new TreeNode(description[0]);
                TreeNode child = new TreeNode(description[1]);
                if (description[2] == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                map.put(parent.val, parent);
                map.put(child.val, child);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int[] description : descriptions) {
            set.add(description[1]);
        }
        for (Integer integer : map.keySet()) {
            if (!set.contains(integer)) {
                root = map.get(integer);
                break;
            }
        }
        return root;
    }
}
