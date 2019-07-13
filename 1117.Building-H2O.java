// https://leetcode.com/problems/building-h2o/
//
// algorithms
// Hard (38.48%)
// Total Accepted: 197
// Total Submissions: 512
// beats 100.0% of java submissions

import java.util.concurrent.Semaphore;

class H2O {
    
    private Semaphore hSemaphore = new Semaphore(0);
    private Semaphore oSemaphore = new Semaphore(1);
    
    private int count;
    
    public H2O() {}

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        count++;
        if ((count & 1) == 0) {
            oSemaphore.release();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();
        releaseOxygen.run();
        
        hSemaphore.release();
        hSemaphore.release();
    }
}