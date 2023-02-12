package tencent.top10.pass4;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinchan
 * @version 1.0.1 2023-02-11
 */
public class Solution01 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left >= right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}

class Solution_ {
    public void reorderList(ListNode head) {

    }
}
