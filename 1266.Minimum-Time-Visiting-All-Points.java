// https://leetcode.com/problems/minimum-time-visiting-all-points/
// algorithms
// Medium (78.72%)
// Total Accepted: 3.7K
// Total Submissions: 4.7K
// beats 100.0% of java submissions


class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int len = points.length;
        if (len == 0) {
            return 0;
        }
        int x = points[0][0], y = points[0][1];

        for (int[] p : points) {
            res += Math.max(Math.abs(x - p[0]), Math.abs(y - p[1]));
            x = p[0];
            y = p[1];
        }

        return res;
    }
}