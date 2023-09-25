package com.medium;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 * Example 1:
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *
 * Constraints:
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 */
public class _707_DesignLinkedList {

    /**
     * Runtime: 9ms Beats 64.55% of users with Java
     * Memory: 44.23MB Beats 51.63% of users with Java
     */
    static class MyLinkedList {

        Node head;
        int length;

        public class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        public MyLinkedList() {
            this.head = null;
            this.length = 0;
        }

        public int get(int index) {
            if (index >= length)
                return -1;
            int counter = 0;
            Node temp = head;
            while (counter < index) {
                counter++;
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            Node newnew = new Node(val);
            newnew.next = head;
            head = newnew;
            length++;
        }

        public void addAtTail(int val) {
            if (head == null) {
                addAtHead(val);
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = new Node(val);
                length++;
            }
        }

        public void addAtIndex(int index, int val) {
            if (index > length)
                return;
            if (index == 0)
                addAtHead(val);
            else {
                int counter = 1;
                Node temp = head;
                while (counter < index) {
                    temp = temp.next;
                    counter++;
                }
                Node newNode = new Node(val);
                Node next = temp.next;
                temp.next = newNode;
                newNode.next = next;
                length++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= length)
                return;
            if (index == 0) {
                head = head.next;
            } else {
                int counter = 1;
                Node temp = head;
                while (counter < index) {
                    counter++;
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            length--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
//        mll.addAtHead(7);
//        mll.addAtHead(2);
//        mll.addAtHead(1);
//        mll.addAtIndex(3, 0);
//        mll.deleteAtIndex(2);
//        mll.addAtHead(6);
//        mll.addAtTail(4);
//        mll.get(4);

        mll.addAtHead(2);
        mll.deleteAtIndex(1);
        mll.addAtHead(2);
        mll.addAtHead(7);
        mll.addAtHead(3);
        mll.addAtHead(2);
        mll.addAtHead(5);
        mll.addAtTail(5);
        mll.get(5);
        mll.deleteAtIndex(6);
        mll.deleteAtIndex(4);
    }
}
