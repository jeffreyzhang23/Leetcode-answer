package easy;

/**Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4
 * Created by Jeffrey on 2016/12/21.
 */
public class PlusOneLinkedList {
    /**
     * 而这题刚好让我们从链尾开始操作，从后往前，遇到进位也要正确的处理，最后还有可能要在开头补上一位。
     * 那么我们反过来想，如果链尾是高位，那么进行加1运算就方便多了，直接就可以边遍历边进行运算处理，那么
     * 我们可以做的就是先把链表翻转一下，然后现在就是链尾是高位了，我们进行加1处理运算结束后，再把链表翻转回来即可
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        if(head == null)
            return head;
        ListNode h1 = reverse(head);
        ListNode p = h1;
        while(p != null) {
            if(p.val + 1 <= 9) {
                p.val = p.val + 1;
                break;
            } else {
                p.val = 0;
                if(p.next == null) {
                    p.next = new ListNode(1);
                    break;
                }
                p = p.next;
            }
        }
        return reverse(h1);
    }
    /**
     * 链表翻转
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
        head.next = null;
        return p1;
    }
}
