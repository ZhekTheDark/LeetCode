package com.easy;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * <p>
 * After doing so, return the array.
 * <p>
 * Example 1:
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 * <p>
 * Example 2:
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 * <p>
 * Constraints:
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
public class ReplaceElementsWithGreatestElementOnRightSide1299 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 2 ms, faster than 83.89% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     * Memory Usage: 44.7 MB, less than 96.57% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     */
    public int[] replaceElements(int[] arr) {
        int max = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                max = arr[i];
                arr[i] = -1;
            } else {
                if (max < arr[i]) {
                    int temp = arr[i];
                    arr[i] = max;
                    max = temp;
                } else {
                    arr[i] = max;
                }
            }
        }

        return arr;
    }
}
