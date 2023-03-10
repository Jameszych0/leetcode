package easy.linklist;

public class IntersectionofTwoLinkedLists160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 让A和B同时走两遍。再走第二遍的时候遇到第一个相同的公共节点就返回，遇不到遍历到最后返回null
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
