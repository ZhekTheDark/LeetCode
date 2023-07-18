package com.easy;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * Example 3:
 * Input: head = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */
public class _206_ReverseLinkedList {

    private static class ListNode {
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
     * Runtime: 0ms Beats 100.00%of users with Java
     * Memory: 41.37mb Beats 71.75%of users with Java
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode prevNode = null;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }
        return prevNode;
    }
}
