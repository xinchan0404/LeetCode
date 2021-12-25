package dailyTopic.daily202112;

import utils.CompleteBinaryTree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1609. 奇偶树
 * 提示：
 * 树中节点数在范围 [1, 105] 内
 * 1 <= Node.val <= 106
 *
 * @author xinchan
 * @version 1.0.1 2021-12-25
 */
public class Daily1225 {
    public static void main(String[] args) {
        /*
         * 创建二叉树
         */
        Integer[] array = {1, 10, 4, 3, null, 7, 9, 12, 8, null, null, 6, null, null, 2};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(array);
        completeBinaryTree.root = completeBinaryTree.fullBinaryTree();
        completeBinaryTree.preorder();

        /*
         * 测试 isEvenOddTree()
         */
        Daily1225 daily1225 = new Daily1225();
        boolean evenOddTreeOrNot = false;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            evenOddTreeOrNot = daily1225.isEvenOddTree(completeBinaryTree.root);  // 1000000: 203 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(evenOddTreeOrNot);
    }

    /**
     * 奇偶树 - bfs
     *
     * @param root
     * @return
     */
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.remove();
                array[i] = cur.val;
                if (cur.left != null) {
                    deque.add(cur.left);
                }
                if (cur.right != null) {
                    deque.add(cur.right);
                }
            }

            int evenOrOdd = level % 2;
            if (size == 1) {
                if (array[0] % 2 == evenOrOdd) {
                    return false;
                } else {
                    level++;
                    continue;
                }
            }
            if (evenOrOdd == 0) {
                for (int i = 0; i < size - 1; i++) {
                    if (array[i] % 2 == evenOrOdd || array[i] >= array[i + 1]) {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < size - 1; i++) {
                    if (array[i] % 2 == evenOrOdd || array[i] <= array[i + 1]) {
                        return false;
                    }
                }
            }
            if (array[size - 1] % 2 == evenOrOdd) {
                return false;
            }

            level++;
        }

        return true;
    }
}
