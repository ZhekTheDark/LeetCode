package com.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStack155 {

    class MinStack {

        List<Integer> stack;

        public MinStack() {
            stack = new ArrayList<>();
        }

        public void push(int val) {
            stack.add(val);
        }

        public void pop() {
            stack.remove(stack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return Collections.min(stack);
        }
    }
}
