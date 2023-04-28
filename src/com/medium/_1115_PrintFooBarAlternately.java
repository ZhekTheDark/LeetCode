package com.medium;

/**
 * Suppose you are given the following code:
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 *
 * The same instance of FooBar will be passed to two different threads:
 * thread A will call foo(), while
 * thread B will call bar().
 * Modify the given program to output "foobar" n times.
 *
 * Example 1:
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar().
 * "foobar" is being output 1 time.
 *
 * Example 2:
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 *
 * Constraints:
 * 1 <= n <= 1000
 */
public class _1115_PrintFooBarAlternately {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 22 ms, faster than 93.39% of Java online submissions for 1115 Print FooBar Alternately.
     * Memory Usage: 42.1 MB, less than 94.71% of Java online submissions for 1115 Print FooBar Alternately.
     */
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
