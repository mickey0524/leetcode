// https://leetcode.com/problems/design-browser-history/
// algorithms
// Medium (60.62%)
// Total Accepted: 8,343
// Total Submissions: 13,762


class BrowserHistory {

    private LinkedList<String> backStack;
    private LinkedList<String> forwardStack;
    private String curUrl;

    public BrowserHistory(String homepage) {
        this.backStack = new LinkedList<>();
        this.forwardStack = new LinkedList<>();
        this.curUrl = homepage;
    }

    public void visit(String url) {
        this.backStack.offerLast(curUrl);
        this.curUrl = url;
        forwardStack.clear();
    }

    public String back(int steps) {
        for (int i = 0; i < steps && !backStack.isEmpty(); i++) {
            forwardStack.offerLast(curUrl);
            this.curUrl = backStack.pollLast();
        }

        return curUrl;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps && !forwardStack.isEmpty(); i++) {
            backStack.offerLast(curUrl);
            this.curUrl = forwardStack.pollLast();

        }

        return curUrl;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage); obj.visit(url); String
 * param_2 = obj.back(steps); String param_3 = obj.forward(steps);
 */
