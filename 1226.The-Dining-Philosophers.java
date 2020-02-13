// https://leetcode.com/problems/the-dining-philosophers/
//
// algorithms
// Medium (46.39%)
// Total Accepted: 2,341
// Total Submissions: 5,046
// beats 100.0% of java submissions


class DiningPhilosophers {

    private static final int PHILOSOPHER_NUM = 5;
    private Semaphore semaphore;
    private ReentrantLock[] locks;

    public DiningPhilosophers() {
        this.semaphore = new Semaphore(4);
        this.locks = new ReentrantLock[PHILOSOPHER_NUM];
        for (int i = 0; i < PHILOSOPHER_NUM; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
            Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        int rightForkNum = philosopher;
        int leftForkNum = philosopher - 1;
        if (leftForkNum < 0) {
            leftForkNum += PHILOSOPHER_NUM;
        }

        semaphore.acquire();
        locks[leftForkNum].lock();
        locks[rightForkNum].lock();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        locks[leftForkNum].unlock();
        locks[rightForkNum].unlock();
        semaphore.release();
    }
}