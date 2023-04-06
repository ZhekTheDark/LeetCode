package com.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 * <p>
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * <p>
 * Constraints:
 * -23^1 <= val <= 23^1 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 */
public class MinStack155 {

    class Pair {

        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * Complexity Analysis:
     * Time complexity : O(1).
     * Space complexity : O(n).
     * <p>
     * Runtime: 5 ms, faster than 74.45% of Java online submissions for Min Stack.
     * Memory Usage: 43.9 MB, less than 96.61% of Java online submissions for Min Stack.
     */
    class MinStack {

        List<Pair> stack;

        public MinStack() {
            this.stack = new LinkedList<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.add(new Pair(val, val));
            } else {
                Pair pair = stack.get(stack.size() - 1);
                Integer newMin = pair.second;
                if (pair.second > val) {
                    newMin = val;
                }
                stack.add(new Pair(val, newMin));
            }
        }

        public void pop() {
            stack.remove(stack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1).first;
        }

        public int getMin() {
            return stack.get(stack.size() - 1).second;
        }
    }
}
