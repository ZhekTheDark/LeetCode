package com.medium;

import java.util.function.IntConsumer;

/**
 * You have a function printNumber that can be called with an integer parameter and prints it to the console.
 * <p>
 * For example, calling printNumber(7) prints 7 to the console.
 * You are given an instance of the class ZeroEvenOdd that has three functions: zero, even, and odd. The same instance of ZeroEvenOdd will be passed to three different threads:
 * <p>
 * Thread A: calls zero() that should only output 0's.
 * Thread B: calls even() that should only output even numbers.
 * Thread C: calls odd() that should only output odd numbers.
 * Modify the given class to output the series "010203040506..." where the length of the series must be 2n.
 * <p>
 * Implement the ZeroEvenOdd class:
 * <p>
 * ZeroEvenOdd(int n) Initializes the object with the number n that represents the numbers that should be printed.
 * void zero(printNumber) Calls printNumber to output one zero.
 * void even(printNumber) Calls printNumber to output one even number.
 * void odd(printNumber) Calls printNumber to output one odd number.
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously.
 * One of them calls zero(), the other calls even(), and the last one calls odd().
 * "0102" is the correct output.
 * <p>
 * Example 2:
 * Input: n = 5
 * Output: "0102030405"
 * <p>
 * Constraints:
 * 1 <= n <= 1000
 */
public class _1116_PrintZeroEvenOdd {

    class ZeroEvenOdd {
        private int n;
        private volatile boolean nextOdd = true;
        private volatile int v = 0;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            int numTimes = this.n;
            for (int i = 0; i < numTimes; i++) {
                while (v != 0) {
                }
                printNumber.accept(0);
                if (nextOdd) {
                    v = 1;
                } else {
                    v = 2;
                }
                nextOdd = !nextOdd;
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            int numTimes = this.n / 2;
            int nextEvenNum = 2;
            for (int i = 0; i < numTimes; i++) {
                while (v != 2) {
                }
                printNumber.accept(nextEvenNum);
                nextEvenNum += 2;
                v = 0;
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            int numTimes = (int) Math.ceil((double) this.n / 2);
            int nextOdd = 1;
            for (int i = 0; i < numTimes; i++) {
                while (v != 1) {
                }
                printNumber.accept(nextOdd);
                nextOdd += 2;
                v = 0;
            }
        }
    }
}
