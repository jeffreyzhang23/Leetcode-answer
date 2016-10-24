package easy;

/**
 * Created by Jeffrey on 2016/9/27.
 */
public class ReverseLinkedList {
    /**
     * Recursive
     *
     * Divide the list into 2 parts - head and the rest starts from head.next
     * Reverse the rest of the linked list
     * Append head to the tail of reversed linked list
     * Return newHead of the reversed linked list
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    /**
     * Iterative
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        A.next = B;
        B.next = C;
        reverseList(A);
    }
}
