// https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
// algorithms
// Medium (46.46%)
// Total Accepted: 3,401
// Total Submissions: 7,321
// beats 100.0% of java submissions


class MaxQueue {

    private LinkedList<Integer> numQ;
    private LinkedList<Integer> maxQ;

    public MaxQueue() {
        this.numQ = new LinkedList<>();
        this.maxQ = new LinkedList<>();
    }

    public int max_value() {
        return numQ.isEmpty() ? -1 : maxQ.peekFirst();
    }

    public void push_back(int value) {
        numQ.offerLast(value);

        while (!maxQ.isEmpty() && value > maxQ.peekLast()) {
            maxQ.pollLast();
        }

        maxQ.offerLast(value);
    }

    public int pop_front() {
        if (numQ.isEmpty()) {
            return -1;
        }
        int res = numQ.pollFirst();
        if (res == maxQ.peekFirst()) {
            maxQ.pollFirst();
        }

        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such: MaxQueue obj =
 * new MaxQueue(); int param_1 = obj.max_value(); obj.push_back(value); int
 * param_3 = obj.pop_front();
 */