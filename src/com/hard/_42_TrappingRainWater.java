package com.hard;

import java.util.Stack;

public class _42_TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null) return 0;
        int res = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < height.length) {
            if (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer bottom = stack.pop();
                int water = 0;
                if (!stack.isEmpty()) {
                    water = (Math.min(height[i], height[stack.peek()]) - height[bottom]) * (i - stack.peek() - 1);
                }
                res += water;
            } else {
                stack.push(i);
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
