package com.easy;

import kotlin.test.AssertionsKt;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 * <p>
 * Example 1:
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * <p>
 * Example 2:
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 * <p>
 * Constraints:
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 9
 */
public class DuplicateZeros1089 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(n).
     * <p>
     * Runtime: 2 ms, faster than 70.8% of Java online submissions for Duplicate Zeros.
     * Memory Usage: 43 MB, less than 37.6% of Java online submissions for Duplicate Zeros.
     */
    public void duplicateZerosExtraSpace(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for (int element : arr) {
            if (element == 0) {
                res.add(element);
                res.add(element);
            } else {
                res.add(element);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
    }

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 0 ms, faster than 100% of Java online submissions for Duplicate Zeros.
     * Memory Usage: 42.2 MB, less than 89.67% of Java online submissions Duplicate Zeros.
     */
    public void duplicateZeros(int[] arr) {
        int rightBorder = arr.length - 1;
        int startInsIndex = arr.length - 1;

        int i = 0;
        while (i <= rightBorder) {
            if (arr[i] == 0) {
                if (i == rightBorder) {
                    rightBorder--;
                    arr[arr.length - 1] = 0;
                    startInsIndex = arr.length - 2;
                    break;
                }
                rightBorder--;
            }
            i++;
        }

        while (rightBorder >= 0) {
            if (arr[rightBorder] == 0) {
                arr[startInsIndex] = 0;
                startInsIndex--;
                arr[startInsIndex] = 0;
            } else {
                arr[startInsIndex] = arr[rightBorder];
            }
            rightBorder--;
            startInsIndex--;
        }
    }

    public static void main(String[] args) {
        int[] actual = {1, 0, 2, 3, 0, 0, 4, 5};
        int[] expected = {1, 0, 0, 2, 3, 0, 0, 0};
        new DuplicateZeros1089().duplicateZeros(actual);
        AssertionsKt.assertContentEquals(actual, expected, "DuplicateZeros1089 test1 failed");
    }
}
