package easy;

/**Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * <p>
 * Tags: Linked List
 * Similar Problems: (E) Remove Element, (E) Delete Node in a Linked List
 * Created by Jeffrey on 2016/11/24.
 */
public class RemoveLinkedListElements {
    /**
     * Create a dummy head and check the next element.
     * If the element is head, the head needs to be updated.
     * If in the middle, we skip this element by connecting previous one to the next next.
     * If the element is tail, doesn't really matter.
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy, next = head;
        while(next != null) {
            if(next.val == val) {
                cur.next = next.next;
            }else {
                cur = cur.next;
            }
            next = next.next;
        }
        return dummy.next;
    }

    /**
     * Recursive version.
     * Base case: if head is null, just return null.
     * Relation: remove elements from current linked list can be divided into two parts:
     * 1. Remove elements from the rest of the list except head
     * 2. Check whether head should be removed
     * The resulted list should be the combination of them.
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null)
            return null;
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }
}
