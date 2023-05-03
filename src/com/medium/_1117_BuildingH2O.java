package com.medium;

public class _1117_BuildingH2O {

    class H2O {

        private int hydrogen = 2;
        private int oxygen = 1;

        public H2O() {

        }

        public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            while (oxygen == 1 && hydrogen == 0) {
                wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hydrogen--;
            if (hydrogen == 0 && oxygen == 0) {
                hydrogen = 2;
                oxygen = 1;
            }
            notifyAll();
        }

        public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
            while (hydrogen > 0 && oxygen == 0) {
                wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            oxygen--;
            if (hydrogen == 0 && oxygen == 0) {
                hydrogen = 2;
                oxygen = 1;
            }
            notifyAll();
        }
    }
}
