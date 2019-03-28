package leetcode;

public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
 
    public ListNode removeElements(ListNode head, int val) {
        /*
            Time Complexity - O(n) where n is the size of the list
            Space Complexity - O(1)
         */
        if (head == null) return null;

        ListNode prev = null;
        ListNode newHead = head;
        ListNode runner = head;

        while (runner != null && runner.val == val) {
            runner = runner.next;
            newHead = runner;
        }

        if (runner == null) {
            return null;
        }

        prev = runner;
        runner = runner.next;

        while (runner != null) {
            if (runner.val == val) {
                prev.next = runner.next;
            } else {
                prev = prev.next;
            }
            runner = runner.next;
        }

        return newHead;
    }
    
}
