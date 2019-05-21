import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/
//
// algorithms
// Easy (64.74%)
// Total Accepted: 4,804
// Total Submissions: 7,420
// beats 100.0% of java submissions

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int n : stones) {
            q.offer(n);
        }

        while (q.size() > 1) {
            int st = q.poll();
            int nd = q.poll();

            if (st > nd) {
                q.offer(st - nd);
            }
        }

        if (q.isEmpty()) {
            return 0;
        }

        return q.peek();
    }
}