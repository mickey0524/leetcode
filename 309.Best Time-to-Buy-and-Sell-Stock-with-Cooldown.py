# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
#
# algorithms
# Medium (43.48%)
# Total Accepted:    83,141
# Total Submissions: 191,230
# beats 100.0% of python submissions


class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        notown = 0
        own, cool = float('-inf'), float('-inf')

        for p in prices:
            notown, own, cool = max(notown, cool), max(
                own, notown - p), own + p

        return max(notown, cool)
