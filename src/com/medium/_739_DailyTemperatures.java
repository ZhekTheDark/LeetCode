package com.medium;

import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that
 * answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * <p>
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * <p>
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * <p>
 * Constraints:
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 */
public class _739_DailyTemperatures {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(n).
     * <p>
     * Runtime: 176 ms, faster than 38.73% of Java online submissions for 739 Daily Temperatures.
     * Memory Usage: 54.7 MB, less than 73.96% of Java online submissions for 739 Daily Temperatures.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() &&
                    temperatures[stack.peek()] < temperatures[i]
            ) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return res;
    }
}
