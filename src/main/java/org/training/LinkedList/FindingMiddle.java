package org.training.LinkedList;

public class FindingMiddle {
    public int solve(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (null == fast.next)
            return slow.val;
        else return slow.next.val;

    }

}
