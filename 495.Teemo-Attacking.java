// https://leetcode.com/problems/teemo-attacking/
//
// algorithms
// Medium (52.82%)
// Total Accepted: 41,218
// Total Submissions: 78,034


class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) {
            return 0;
        }

        int res = 0;
        int l = -1, r = -1;
        for (int t : timeSeries) {
            if (l == -1) {
                l = t;
                r = t + duration;
            } else if (t <= r) {
                r = Math.max(r, t + duration);
            } else {
                res += (r - l);
                l = t;
                r = t + duration;
            }
        }

        return res + r - l;
    }
}