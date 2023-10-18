package com.medium;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * Follow up: Could you do this in one pass?
 */
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
