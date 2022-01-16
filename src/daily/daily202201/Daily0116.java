package daily.daily202201;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-16
 */
public class Daily0116 {
    private List<Integer> list;
    private Random random;
    private int size;
    /**
     * 382. 链表随机节点 - 辅助数组
     * @param head
     */
    public Daily0116(ListNode head) {
        list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        random = new Random(20220116);
        size = list.size();
    }

    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}
