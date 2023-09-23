package com.medium;

public class _707_DesignLinkedList {

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
