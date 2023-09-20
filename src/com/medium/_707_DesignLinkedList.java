package com.medium;

public class _707_DesignLinkedList {

    class MyLinkedList {

        ListNode node = null;

        public class ListNode {
            int val;
            ListNode next;
            public ListNode(int x) { val = x; }
        }

        public MyLinkedList() {

        }

        public int get(int index) {
            ListNode cur = this.node;
            while (index-- > 0) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {

        }

        public void addAtTail(int val) {

        }

        public void addAtIndex(int index, int val) {

        }

        public void deleteAtIndex(int index) {

        }
    }
}
