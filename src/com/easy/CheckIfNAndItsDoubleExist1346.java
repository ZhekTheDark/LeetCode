package com.easy;

import kotlin.test.AssertionsKt;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array arr of integers, check if there exist two indices i and j such that :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 * <p>
 * Example 2:
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 * <p>
 * Constraints:
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class CheckIfNAndItsDoubleExist1346 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 1 ms, faster than 99.60% of Java online submissions for Check If N and Its Double Exist.
     * Memory Usage: 41.7 MB, less than 84.40% of Java online submissions for Check If N and Its Double Exist.
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int element : arr) {
            if (set.contains(element * 2) || (element % 2 == 0 && set.contains(element / 2))) {
                return true;
            }
            set.add(element);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 10, -19, 4, 6, -8};

        boolean res = new CheckIfNAndItsDoubleExist1346().checkIfExist(arr);
        AssertionsKt.assertEquals(false, res, "CheckIfNAndItsDoubleExist1346 test failed");
    }
}
