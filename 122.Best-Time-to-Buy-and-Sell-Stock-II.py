# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
#
# algorithms
# Easy (50.91%)
# Total Accepted:    293,229
# Total Submissions: 575,993
# beats 100.0% of python submissions

# Greedy，在涨就不卖

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        length = len(prices)

        if length < 2:
            return 0

        i, res = 0, 0
        while i < length:
            j = i + 1
            while j < length and prices[j] >= prices[j - 1]:
                j += 1
            res += prices[j - 1] - prices[i]
            if j == length:
                break
            i = j

        return res
