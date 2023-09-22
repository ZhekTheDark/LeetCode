package com.medium;

public class _707_DesignLinkedList {

    class MyLinkedList {

        ListNode node = null;
        ListNode head = null;
        ListNode tail = null;

        public class ListNode {
            int val;
            ListNode next;
            public ListNode(int x) { val = x; }
        }

        public MyLinkedList() {

        }

        public int get(int index) {
            ListNode cur = head;
            while (index-- > 0) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        }

        public void addAtTail(int val) {
            ListNode newTail = new ListNode(val);
            tail.next = newTail;
            tail = newTail;
        }

        public void addAtIndex(int index, int val) {

        }

        public void deleteAtIndex(int index) {

        }
    }
}
