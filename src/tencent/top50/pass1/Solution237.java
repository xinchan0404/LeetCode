package tencent.top50.pass1;

import utils.ListNode;

/**
 * 237. 删除链表中的节点
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
