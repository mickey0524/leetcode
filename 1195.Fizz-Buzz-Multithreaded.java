// https://leetcode.com/problems/fizz-buzz-multithreaded/
//
// algorithms
// Medium (66.49%)
// Total Accepted: 426
// Total Submissions: 641
// beats 100.0% of java submissions


import java.util.concurrent.Semaphore;

class FizzBuzz {
    private int n;

    private Semaphore numberSemaphore = new Semaphore(1);
    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzbuzzSemaphore = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int i = 3;
        while (i <= n) {
            fizzSemaphore.acquire();
            printFizz.run();
            numberSemaphore.release();
            if ((i + 3) % 5 == 0) {
                i += 6;
            } else {
                i += 3;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int i = 5;
        while (i <= n) {
            buzzSemaphore.acquire();
            printBuzz.run();
            numberSemaphore.release();
            if ((i + 5) % 3 == 0) {
                i += 10;
            } else {
                i += 5;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzbuzzSemaphore.acquire();
            printFizzBuzz.run();
            numberSemaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numberSemaphore.acquire();
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    fizzbuzzSemaphore.release();
                } else {
                    fizzSemaphore.release();
                }
            } else if (i % 5 == 0) {
                buzzSemaphore.release();
            } else {
                printNumber.accept(i);
                numberSemaphore.release();
            }
        }
    }
}