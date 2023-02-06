package com.easy;

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
     * Runtime: 2 ms, faster than 70.8% of Java online submissions for Squares of a Duplicate Zeros.
     * Memory Usage: 43 MB, less than 37.6% of Java online submissions for Squares of a Duplicate Zeros.
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

//    1,0,2,3,0,0,4,5
//    1,0,0,2,3,0,0,0

//    1,0,2,3,0,4,5,6
//    1,0,0,2,3,0,0,4

//    0,0,0,0,0,0,0
    public void duplicateZeros(int[] arr) {
        int rightBorder = arr.length - 1;
//        int last = arr.length - 1;

        int i = 0;
        while (i <= rightBorder) {
            if (arr[i] == 0) {
                if (i == rightBorder) {
                    rightBorder--;
                    arr[arr.length - 1] = 0;
//                    last = arr.length - 2;
                    break;
                }
                rightBorder--;
            }
            i++;
        }

        while (rightBorder >= 0) {
            if (arr[rightBorder] == 0) {
                arr[last] = 0;
                last--;
                if (last != 0) {
                    arr[last] = 0;
                }
            } else {
                arr[last] = arr[rightBorder];
            }
            rightBorder--;
            last--;
        }
    }

//    public void duplicateZeros(int[] arr) {
//        int zeros = 0;
//
//    }
}
