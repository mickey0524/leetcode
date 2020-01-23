// https://leetcode.com/problems/number-of-recent-calls/
//
// algorithms
// Easy (70.08%)
// Total Accepted: 35,423
// Total Submissions: 50,545


class RecentCounter {

    private static final int THRESHOLD = 3000;
    private LinkedList<Integer> l;

    public RecentCounter() {
        this.l = new LinkedList<>();
    }

    public int ping(int t) {
        while (!l.isEmpty() && l.peekFirst() < t - THRESHOLD) {
            l.pollFirst();
        }

        l.add(t);
        return l.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter(); int param_1 = obj.ping(t);
 */