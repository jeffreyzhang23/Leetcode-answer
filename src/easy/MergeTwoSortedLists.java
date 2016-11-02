package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jeffrey on 2016/10/26.
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        List<ListNode> list = new LinkedList<ListNode>();
        while(p != null && q != null) {
            if(p.val == q.val) {
                list.add(p);
                p = p.next;
                q = q.next;
                if(p == null && q != null){
                    while(q != null) {
                        list.add(q);
                        q = q.next;
                    }
                }
                if(q == null && p != null) {
                    while(p != null) {
                        list.add(p);
                        p = p.next;
                    }
                }
            } else if(p.val < q.val) {
                list.add(p);
                p = p.next;
                if(p == null && q != null){
                    while(q != null) {
                        list.add(q);
                        q = q.next;
                    }
                }
            } else if(p.val > q.val) {
                list.add(q);
                q = q.next;
                if(q == null && p != null) {
                    while(p != null) {
                        list.add(p);
                        p = p.next;
                    }
                }
            }
        }
        for(int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode beforeHead = new ListNode(0);
        ListNode temp = new ListNode(0);
        beforeHead.next = temp;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while(l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return beforeHead.next.next;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode m1 = mergeTwoLists(n1, n5);
        ListNode temp = m1;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
