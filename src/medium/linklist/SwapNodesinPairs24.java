package medium.linklist;

public class SwapNodesinPairs24 {
    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        // 限制条件，遍历到最后，偶数第二个条件，奇数第一个条件
        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next; // 防止要交换的第一个节点丢失
            ListNode temp2 = cur.next.next.next; // 防止第二个节点后一个节点消失
            cur.next = cur.next.next; // 把要交换的前一个节点指向第二个节点
            cur.next.next = temp1; // 把第二个节点指向第一个节点
            cur.next.next.next = temp2; // 把第一个节点指向第二个节点的后一个节点
            cur = cur.next.next; // cur向后移两位
        }
        return dummyHead.next;
    }
}
