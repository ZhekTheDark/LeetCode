package com.medium;

public class _142_LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return null;
//        }
//        ListNode slow = head;
//        ListNode fast = head;
//
//        do {
//            slow = slow.next;
//            fast = fast.next;
//            if (fast.next == null) {
//                return null;
//            }
//            fast = fast.next;
//            if (fast.next == null) {
//                return null;
//            }
//        } while (slow != fast);
//
//        ListNode start = head;
//        while (start != slow && start != slow.next) {
//            start = start.next;
//        }
//        return start;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        ListNode start = detectCycle(node0);
        System.out.println(start);
    }
}
