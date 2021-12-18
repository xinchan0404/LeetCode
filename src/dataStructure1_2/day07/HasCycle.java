package dataStructure1_2.day07;

import utils.CycleLinkedList;
import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 提示：
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 *
 * @author xinchan
 * @version 1.0.1 2021-12-18
 */
public class HasCycle {
    public static void main(String[] args) {
        /*
         * 创建环形单链表
         */
        CycleLinkedList cycleLinkedList = new CycleLinkedList();
        int[] array = {3, 2, 0, -4};
        int pos = 0;
        cycleLinkedList.createCycleLinkedList(array, pos);
        cycleLinkedList.traversal();
        ListNode head = cycleLinkedList.head;

        /*
         * 测试 hasCycle()
         */
        HasCycle hasCycle = new HasCycle();
        boolean hasOrNot = false;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            hasOrNot = hasCycle.hasCycle(head);  // 1000000 次: 50 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("\n耗时：" + costMs + " ms");

        System.out.println(hasOrNot);
    }

    /**
     * 环形链表 - HashSet
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (!set.add(cur)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    /**
     * 环形链表 - 快慢指针， Floy算法
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (true) {

        }
    }
}
