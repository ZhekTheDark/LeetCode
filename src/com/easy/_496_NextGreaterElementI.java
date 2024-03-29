package com.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * <p>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater
 * element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 * <p>
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * <p>
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 * <p>
 * Constraints:
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 10^4
 * All integers in nums1 and nums2 are unique.
 * All the integers of nums1 also appear in nums2.
 * <p>
 * Follow up: Could you find an O(nums1.length + nums2.length) solution?
 */
public class _496_NextGreaterElementI {

    /**
     * Complexity Analysis:
     * Time complexity : O(n * m).
     * Space complexity : O(1).
     * <p>
     * Runtime: 3 ms, faster than 91.39% of Java online submissions for Next Greater ElementI.
     * Memory Usage: 43.6 MB, less than 5.18% of Java online submissions for Next Greater ElementI.
     */
    public int[] nextGreaterElementV1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            int j = 0;
            while (nums2[j] != nums1[i]) {
                j++;
            }
            while (res[i] == -1 &&
                j < nums2.length
            ) {
                if (nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                }
                j++;
            }
        }

        return res;
    }

    /**
     * Complexity Analysis:
     * Time complexity : O(n + m).
     * Space complexity : O(m).
     * <p>
     * Runtime: 4 ms, faster than 75.25% of Java online submissions for Next Greater ElementI.
     * Memory Usage: 43.7 MB, less than 12.9% of Java online submissions for Next Greater ElementI.
     */
    public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                stack.peek() < nums2[i]
            ) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    map.put(pop, -1);
                } else {
                    map.put(pop, stack.peek());
                }
            }

            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (stack.isEmpty()) {
                map.put(pop, -1);
            } else {
                map.put(pop, stack.peek());
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }

    /**
     * Complexity Analysis:
     * Time complexity : O(n + m).
     * Space complexity : O(m).
     * <p>
     * Runtime: 2 ms, faster than 99.39% of Java online submissions for Next Greater ElementI.
     * Memory Usage: 43.4 MB, less than 15.83% of Java online submissions for Next Greater ElementI.
     */
    public int[] nextGreaterElementV3_1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int[] stk = new int[nums2.length];
        Map<Integer, Integer> map = new HashMap<>();
        int top = -1;

        for (int num : nums2) {
            while (top >= 0 && stk[top] < num) {
                map.put(stk[top--], num);
            }
            stk[++top] = num;
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }

    /**
     * Complexity Analysis:
     * Time complexity : O(n + m).
     * Space complexity : O(m).
     * <p>
     * Runtime: 4 ms, faster than 75.25% of Java online submissions for Next Greater ElementI.
     * Memory Usage: 43.7 MB, less than 12.9% of Java online submissions for Next Greater ElementI.
     */
    public int[] nextGreaterElementV3_2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() &&
                stack.peek() < num
            ) {
                Integer pop = stack.pop();
                map.put(pop, num);
            }

            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}
