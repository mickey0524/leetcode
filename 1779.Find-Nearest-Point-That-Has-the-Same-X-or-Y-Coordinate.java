// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
// algorithms
// Easy (67.81%)
// Total Accepted: 6,227
// Total Submissions: 9,183


class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int dis = Integer.MAX_VALUE;
        int res = -1;
        int len = points.length;

        for (int i = 0; i < len; i++) {
            int[] p = points[i];

            if (p[0] == x) {
                int tmp = Math.abs(p[1] - y);
                if (tmp < dis) {
                    dis = tmp;
                    res = i;
                }
            } else if (p[1] == y) {
                int tmp = Math.abs(p[0] - x);
                if (tmp < dis) {
                    dis = tmp;
                    res = i;
                }
            }
        }

        return res;
    }
}