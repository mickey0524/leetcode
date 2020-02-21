// https://leetcode.com/problems/range-addition-ii/
//
// algorithms
// Easy (49.27%)
// Total Accepted: 36,859
// Total Submissions: 74,887
// beats 100.0% of java submissions


class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }

        return m * n;
    }
}