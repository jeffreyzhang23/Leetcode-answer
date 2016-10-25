package easy;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
        	while(cur.next != null && cur.val == cur.next.val) {
        		cur.next = cur.next.next;
        	}
        	cur = cur.next;
        }
        return head;
    }
	public ListNode deleteDuplicates2(ListNode head) {
		if(head == null) return head;
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null) {
			while(cur != null && cur.val == pre.val) {
				cur = cur.next;
			}
			pre.next = cur;
			pre = cur;
			if(cur != null) 
				cur = cur.next;
		}
		return dummyNode.next;
	}
}
