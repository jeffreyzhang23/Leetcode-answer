package easy;

/**Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should
 * become 1 -> 2 -> 4 after calling your function.
 * Created by Jeffrey on 2016/9/12.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class DeleteNodeInALinkedList {
    public void Solution(ListNode node) {
        //because the deleted node is not the tail.
        //so we can move the next node's content to this one, and delete the next one.
        if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
