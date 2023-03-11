package com.medium;

import kotlin.test.AssertionsKt;

public class DesignCircularQueue622 {

    static class MyCircularQueue {
        int[] arr;
        int head;
        int tail;
        int size;

        public MyCircularQueue(int k) {
            arr = new int[k];
            head = 0;
            tail = 0;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            } else {
                if (!isEmpty()) {
                    if (tail == arr.length - 1) {
                        tail = 0;
                    } else {
                        tail++;
                    }
                }
                arr[tail] = value;
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                if (head == arr.length - 1) {
                    head = 0;
                } else {
                    head++;
                }
                size--;
                return true;
            }
        }

        public int Front() {
            return arr[head];
        }

        public int Rear() {
            return arr[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == arr.length - 1;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        AssertionsKt.assertTrue(queue.enQueue(1), "");
        AssertionsKt.assertTrue(queue.enQueue(2), "");
        AssertionsKt.assertTrue(queue.enQueue(3), "");
        AssertionsKt.assertFalse(queue.enQueue(4), "");
        AssertionsKt.assertEquals(3, queue.Rear(), "");
        AssertionsKt.assertTrue(queue.isFull(), "");
        AssertionsKt.assertTrue(queue.deQueue(), "");
        AssertionsKt.assertTrue(queue.enQueue(4), "");
        queue.Rear();
    }
}
