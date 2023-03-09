package com.easy;

public class FindLuckyIntegerInAnArray1394 {

    public int findLucky(int[] arr) {
        int[] num = new int[501];
        for (int a : arr) {
            num[a]++;
        }
        for (int i = 500; i > 0; i--) {
            if (num[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
