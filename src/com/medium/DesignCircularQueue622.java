package com.medium;

import kotlin.test.AssertionsKt;

import java.util.Arrays;

/**
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which
 * the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back
 * to the first position to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
 * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
 * But using the circular queue, we can use the space to store new values.
 * <p>
 * Implement the MyCircularQueue class:
 * <p>
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * int Front() Gets the front item from the queue. If the queue is empty, return -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 * You must solve the problem without using the built-in queue data structure in your programming language.
 * <p>
 * Example 1:
 * Input
 * ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * Output
 * [null, true, true, true, false, 3, true, true, true, 4]
 * <p>
 * Explanation
 * MyCircularQueue myCircularQueue = new MyCircularQueue(3);
 * myCircularQueue.enQueue(1); // return True
 * myCircularQueue.enQueue(2); // return True
 * myCircularQueue.enQueue(3); // return True
 * myCircularQueue.enQueue(4); // return False
 * myCircularQueue.Rear();     // return 3
 * myCircularQueue.isFull();   // return True
 * myCircularQueue.deQueue();  // return True
 * myCircularQueue.enQueue(4); // return True
 * myCircularQueue.Rear();     // return 4
 * <p>
 * Constraints:
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.
 */
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
