package com.medium;

import java.util.function.IntConsumer;

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
