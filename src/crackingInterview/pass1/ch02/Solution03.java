package crackingInterview.pass1.ch02;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Solution03 {
    /**
     * 面试题 02.03. 删除中间节点 - 节点值前移
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 面试题 02.03. 删除中间节点 - 节点值前移
     * @param node
     */
    public void deleteNode1(ListNode node) {
        ListNode cur = node;
        while (cur.next != null) {
            cur.val = cur.next.val;
            if (cur.next.next == null) {
                cur.next = null;
            } else {
                cur = cur.next;
            }
        }
    }
}
