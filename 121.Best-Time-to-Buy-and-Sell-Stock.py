# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
#
# algorithms
# Easy (46.23%)
# Total Accepted:    439,733
# Total Submissions: 951,179
# beats 100.0% of python submissions


class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        length = len(prices)

        if length < 2:
            return 0

        cur_min, res = prices[0], 0

        for i in xrange(1, length):
            res = max(res, prices[i] - cur_min)
            cur_min = min(cur_min, prices[i])

        return res
