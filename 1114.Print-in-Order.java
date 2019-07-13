// https://leetcode.com/problems/print-in-order/
//
// algorithms
// Easy (58.2%)
// Total Accepted: 692
// Total Submissions: 1,189
// beats 100.0% of java submissions

class Foo {
    
    private volatile int flag;
    
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (flag == 0) {
            continue;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag < 2) {
            continue;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        flag++;
    }
}

