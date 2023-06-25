package com.hard;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * <p>
 * Constraints:
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class _42_TrappingRainWater {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(n).
     * <p>
     * Runtime: 13 ms, faster than 11.56% of Java online submissions for Trapping Rain Water.
     * Memory Usage: 43.4 MB, less than 75.88% of Java online submissions for Trapping Rain Water.
     */
    public static int trapStack(int[] height) {
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
        System.out.println(trapStack(height));
    }
}
