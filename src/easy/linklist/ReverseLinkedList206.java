package easy.linklist;

public class ReverseLinkedList206 {
    //双指针法
    public ListNode reverseList_way1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 保存cur的下一个节点，防止链表丢失
            ListNode temp = cur.next; //ListNode temp = cur;
            // 反转链表
            cur.next = pre;
            // 指针向后移一位
            pre = cur;
            cur = temp;               //cur = temp.next;
        }                             //这样写无法找到cur下一个连接的节点
        return pre;
    }
    //递归 对照双指针法写
    public ListNode reverseList_way2(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}
