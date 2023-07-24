package com.easy;

import java.util.Arrays;

public class _66_PlusOne {

    public static int[] plusOne(int[] digits) {
        String s = Arrays
                .stream(digits)
                .mapToObj(String::valueOf)
                .reduce(String::concat)
                .get();

        int integer = Integer.parseInt(s) + 1;
        return Integer.toString(integer).chars().map(c -> c - '0').toArray();
    }

    public static void main(String[] args) {
        int[] input = {1, 1};
        System.out.println(plusOne(input).);
    }
}
