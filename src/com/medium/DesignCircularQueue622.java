package com.medium;

import kotlin.test.AssertionsKt;

import java.util.Arrays;

public class DesignCircularQueue622 {

    /**
     * Complexity Analysis:
     * Space complexity : O(1).
     * <p>
     * Runtime: 4 ms, faster than 75.61% of Java online submissions for Design Circular Queue.
     * Memory Usage: 43 MB, less than 32.93% of Java online submissions for Design Circular Queue.
     */
    static class MyCircularQueue {
        int[] arr;
        int head;
        int tail;
        int size;

        public MyCircularQueue(int k) {
            arr = new int[k];
            Arrays.fill(arr, -1);
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
                arr[head] = -1;
                size--;
                if (!isEmpty()) {
                    if (head == arr.length - 1) {
                        head = 0;
                    } else {
                        head++;
                    }
                }
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
            return size == arr.length;
        }
    }

    public static void main(String[] args) {
        // test 1
        MyCircularQueue queue = new MyCircularQueue(3);
        AssertionsKt.assertTrue(queue.enQueue(1), "");
        AssertionsKt.assertTrue(queue.enQueue(2), "");
        AssertionsKt.assertTrue(queue.enQueue(3), "");
        AssertionsKt.assertFalse(queue.enQueue(4), "");
        AssertionsKt.assertEquals(3, queue.Rear(), "");
        AssertionsKt.assertTrue(queue.isFull(), "");
        AssertionsKt.assertTrue(queue.deQueue(), "");
        AssertionsKt.assertTrue(queue.enQueue(4), "");
        AssertionsKt.assertEquals(4, queue.Rear(), "");

        // test 34
        MyCircularQueue queue34 = new MyCircularQueue(6);
        AssertionsKt.assertTrue(queue34.enQueue(6), "");
        AssertionsKt.assertEquals(6, queue34.Rear(), "");
        AssertionsKt.assertEquals(6, queue34.Rear(), "");
        AssertionsKt.assertTrue(queue34.deQueue(), "");
        AssertionsKt.assertTrue(queue34.enQueue(5), "");
        AssertionsKt.assertEquals(5, queue34.Rear(), "");
        AssertionsKt.assertTrue(queue34.deQueue(), "");
        AssertionsKt.assertEquals(-1, queue34.Front(), "");
        AssertionsKt.assertFalse(queue34.deQueue(), "");
        AssertionsKt.assertFalse(queue34.deQueue(), "");
        AssertionsKt.assertFalse(queue34.deQueue(), "");
    }
}
