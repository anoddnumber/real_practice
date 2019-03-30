package leetcode;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> s = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (s.contains(headA)) return headA;
                s.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (s.contains(headB)) return headB;
                s.add(headB);
                headB = headB.next;
            }
        }

        return null;
    }
}
