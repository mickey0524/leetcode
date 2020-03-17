// https://leetcode.com/problems/design-a-stack-with-increment-operation/
// algorithms
// Easy (71.96%)
// Total Accepted: 6,681
// Total Submissions: 9,284


class CustomStack {

    private int[] stack;
    private int curIdx;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (curIdx == maxSize) {
            return;
        }

        stack[curIdx++] = x;
    }

    public int pop() {
        if (curIdx == 0) {
            return -1;
        }

        return stack[--curIdx];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, curIdx); i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such: CustomStack
 * obj = new CustomStack(maxSize); obj.push(x); int param_2 = obj.pop();
 * obj.increment(k,val);
 */