package com.hard;

import java.util.Stack;

public class _42_TrappingRainWater {

    private static class Pair {

        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int trap(int[] height) {
        int res = 0;
        Stack<Pair> stack = new Stack<>();
        Stack<Pair> local = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            int blockHeight = height[i];
            int prev = 0;
            while (!stack.isEmpty() && stack.peek().second < blockHeight) {
                Pair pop = stack.pop();
                local.push(pop);
            }
            while (!local.isEmpty()) {
                Pair pop = local.pop();
                int h = Math.min(prev, blockHeight);
                res = res + h - pop.second;
                height[pop.first] = h;
            }
            stack.push(new Pair(i, height[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
