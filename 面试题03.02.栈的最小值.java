// https://leetcode-cn.com/problems/min-stack-lcci/
// algorithms
// Easy (62.14%)
// Total Accepted: 2,006
// Total Submissions: 3,228



class MinStack {
    
    private LinkedList<Integer> numStack;
    private LinkedList<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.numStack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }
    
    public void push(int x) {
        numStack.offerLast(x);
        if (minStack.isEmpty()) {
            minStack.offerLast(x);
        } else {
            int curTmp = minStack.peekLast();
            minStack.offerLast(Math.min(curTmp, x));
        }
    }
    
    public void pop() {
        if (!numStack.isEmpty()) {
            numStack.pollLast();
            minStack.pollLast();
        }
    }
    
    public int top() {
        return numStack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */