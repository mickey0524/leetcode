// https://leetcode.com/problems/print-foobar-alternately/
//
// algorithms
// Medium (54.66%)
// Total Accepted: 340
// Total Submissions: 622
// beats 100.0% of java submissions

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            foo.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}