package tencent.top10.pass5;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 026. 重排链表
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Solution1 {
    public void reorderList(ListNode head) {
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();

        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}
