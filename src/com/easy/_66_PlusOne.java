package com.easy;

import java.util.Arrays;

public class _66_PlusOne {

    public int[] plusOneNotWorking(int[] digits) {
        String s = Arrays
                .stream(digits)
                .mapToObj(String::valueOf)
                .reduce(String::concat)
                .get();

        int integer = Integer.parseInt(s) + 1;
        return Integer.toString(integer).chars().map(c -> c - '0').toArray();
    }

    /**
     * Runtime: 0ms Beats 100.00% of users with Java
     * Memory: 40.86mb Beats 81.73% of users with Java
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
