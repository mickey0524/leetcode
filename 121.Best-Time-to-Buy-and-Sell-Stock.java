// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//
// algorithms
// Easy (47.14%)
// Total Accepted: 491,819
// Total Submissions: 1,043,382


class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int cur_min = Integer.MAX_VALUE;

        for (int p : prices) {
            res = Math.max(p - cur_min, res);
            cur_min = Math.min(cur_min, p);
        }

        return res;
    }
}