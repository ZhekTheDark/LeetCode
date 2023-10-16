package com.medium;

public class _19_RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Runtime: 0ms Beats 100.00% of users with Java
     * Memory: 40.30MB Beats 80.13% of users with Java
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        int i = 0;
        ListNode node = head;
        while (n - i > 0) {
            node = node.next;
            i++;
        }
        ListNode target = head;

        if (node.next == null) {
            target = target.next;
            return target;
        }

        while (node.next != null) {
            node = node.next;
            target = target.next;
        }

        target.next = target.next.next;
        return head;
    }
}
