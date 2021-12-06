package dataStructure.day07;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 提示：
 * 1. 链表中节点的数目范围是 [0, 104]
 * 2. -105 <= Node.val <= 105
 * 3. pos 为 -1 或者链表中的一个 有效索引 。
 *
 * @author xinchan
 * @version 1.0.1 2021-12-02
 */
public class HasCycle {
    public static void main(String[] args) {
        /*
         * 创建带环链表
         */
        CycleLinkedList cycleLinkedList = new CycleLinkedList();

        int[] array = {3, 2, 0, -4};
        int pos = -1;

        cycleLinkedList.createCycleLinkedList(array, pos);

        ListNode head = cycleLinkedList.getHead();

        /*
         * 测试 hasCycle 方法
         */
        boolean hasCycle = hasCycle1(head);

        System.out.println(hasCycle);
    }

    /**
     * 单链表是否带环 - HashSet
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode tmp = head;
        Set<ListNode> set = new HashSet<>();

        while (tmp != null) {
            if (!set.add(tmp)) {
                return true;
            }
            tmp = tmp.next;
        }

        return false;
    }

    /**
     * 单链表是否带环 - Floyd 判环算法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return  true;
    }
}
