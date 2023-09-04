package com.easy;

import java.util.LinkedList;
import java.util.Queue;

public class _225_ImplementStackUsingQueues {

    /**
     * Runtime: 0ms Beats 100.00% of users with Java
     * Memory: 40.54MB Beats 14.18% of users with Java
     */
    class MyStack {

        Queue<Integer> queue = new LinkedList();

        public MyStack() {

        }

        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
