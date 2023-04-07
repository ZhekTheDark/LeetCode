package com.easy;

public class PrintInOrder1114 {

    class Foo {
        volatile boolean firstReady = false;
        volatile boolean secondReady = false;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstReady = true;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (!firstReady)
                Thread.yield();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondReady = true;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!secondReady)
                Thread.yield();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
