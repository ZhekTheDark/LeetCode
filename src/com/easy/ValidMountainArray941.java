package com.easy;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * <p>
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 * <p>
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * <p>
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 * <p>
 * Constraints:
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^4
 */
public class ValidMountainArray941 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 1 ms, faster than 100% of Java online submissions for Valid Mountain Array.
     * Memory Usage: 42.9 MB, less than 97.55% of Java online submissions for Valid Mountain Array.
     */
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int size = arr.length;

        while (i + 1 < size && arr[i + 1] > arr[i]) {
            i++;
        }

        if (i == 0 || i == size - 1) {
            return false;
        }

        while (i + 1 < size && arr[i + 1] < arr[i]) {
            i++;
        }

        return i == size - 1;
    }
}
