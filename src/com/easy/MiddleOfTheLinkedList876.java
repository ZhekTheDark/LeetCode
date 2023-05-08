package com.easy;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * Constraints:
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(1).
 * <p>
 * Runtime: 0 ms, faster than 100% of Java online submissions for Middle of the Linked List.
 * Memory Usage: 39.7 MB, less than 89.77% of Java online submissions for Middle of the Linked List.
 */
public class MiddleOfTheLinkedList876 {

    public ListNode middleNode(ListNode head) {
        ListNode mirrorListNode = head;
        int step = 0;

        while (head.getNext() != null) {
            if (mirrorListNode.getNext() == null) {
                return head;
            }
            step++;
            head = head.getNext();
            mirrorListNode = head;
            for (int i = 0; i < step; i++) {
                if (mirrorListNode.getNext() != null) {
                    mirrorListNode = mirrorListNode.getNext();
                } else {
                    return head;
                }
            }
        }

        return head;
    }
}
