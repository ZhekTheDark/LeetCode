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

    public boolean hasCycle(ListNode head) {
        if (if (head == null || head.next == null) {
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
