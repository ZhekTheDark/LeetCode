package com.medium;

public class _1115_PrintFooBarAlternately {

    class FooBar {
        private int n;
        private volatile int flag = 0;

        public FooBar(int n) {
            this.n = n;
            this.flag = 0;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while(flag != 0) {}
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while(flag != 1) {}
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 0;
            }
        }
    }
}
