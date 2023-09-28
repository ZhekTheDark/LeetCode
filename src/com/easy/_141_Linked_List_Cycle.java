package com.easy;

public class _141_Linked_List_Cycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Runtime: 0ms Beats 100.00% of users with Java
     * Memory: 43.44MB Beats 57.73% of users with Java
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while (pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
            if (pointer2.next == null) {
                return false;
            } else {
                pointer2 = pointer2.next;
            }
            if (pointer1 == pointer2) {
                return true;
            }
        }
        return false;
    }
}
