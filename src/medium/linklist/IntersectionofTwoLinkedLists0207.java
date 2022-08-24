package medium.linklist;
/*
 * 题目大意
 * A,B两个链表从某个节点开始，后面都相同了
 * 大致解法
 * 先将A“移到”B的开头，然后一一比较
 * A -----
 * B   ---
 */
public class IntersectionofTwoLinkedLists0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        // 计算两个链表的长度
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        // 回到头节点
        curA = headA;
        curB = headB;
        // 比较两个链表的长度，如B>A，交换一下，方便后面操作
        if (lenB > lenA) {
            int tempLen;
            tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;

            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        // 算长度差
        int gap = lenA - lenB;
        for (int i = 0; i < gap; i++) {
            curA = curA.next;
        }
        // 比较
        while (curA != null) {
            if (curA == curB) 
                return curA;
            else {
                curA = curA.next;
                curB = curB.next;
            }
        }

        return null;
    }
}
