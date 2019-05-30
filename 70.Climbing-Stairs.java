// https://leetcode.com/problems/climbing-stairs/
//
// algorithms
// Easy (44.18%)
// Total Accepted: 403,545
// Total Submissions: 913,502

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int st = 1, nd = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = st + nd;
            st = nd;
            nd = tmp;
        }

        return nd;
    }
}