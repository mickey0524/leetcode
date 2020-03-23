// https://leetcode-cn.com/problems/three-in-one-lcci/
// algorithms
// Easy (56.0%)
// Total Accepted: 737
// Total Submissions: 1,316


class TripleInOne {

    private int[] stack;
    private int[] leftBorder;
    private int[] rightBorder;
    private int[] curInsertIdx;

    public TripleInOne(int stackSize) {
        this.stack = new int[stackSize * 3];
        this.leftBorder = new int[] { 0, stackSize, stackSize * 2 };
        this.rightBorder = new int[] { stackSize - 1, stackSize * 2 - 1, stackSize * 3 - 1 };
        this.curInsertIdx = new int[] { 0, stackSize, stackSize * 2 };
    }

    public void push(int stackNum, int value) {
        if (curInsertIdx[stackNum] > rightBorder[stackNum]) {
            return;
        }

        stack[curInsertIdx[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        if (curInsertIdx[stackNum] <= leftBorder[stackNum]) {
            return -1;
        }

        return stack[--curInsertIdx[stackNum]];
    }

    public int peek(int stackNum) {
        if (curInsertIdx[stackNum] <= leftBorder[stackNum]) {
            return -1;
        }

        return stack[curInsertIdx[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return curInsertIdx[stackNum] <= leftBorder[stackNum];
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such: TripleInOne
 * obj = new TripleInOne(stackSize); obj.push(stackNum,value); int param_2 =
 * obj.pop(stackNum); int param_3 = obj.peek(stackNum); boolean param_4 =
 * obj.isEmpty(stackNum);
 */