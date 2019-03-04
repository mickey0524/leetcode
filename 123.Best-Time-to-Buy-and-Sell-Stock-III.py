# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
#
# algorithms
# Hard (32.98%)
# Total Accepted:    138,708
# Total Submissions: 421,258
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

        buy_st, buy_nd = -prices[0], -prices[0]
        sell_st, sell_nd = 0, 0

        for n in prices[1:]:
            buy_st = max(buy_st, -n)
            sell_st = max(sell_st, n + buy_st)
            buy_nd = max(buy_nd, sell_st - n)
            sell_nd = max(sell_nd, buy_nd + n)

        return sell_nd


class Solution1(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        length = len(prices)
        if length < 2:
          return 0
        left, right = [0] * length, [0] * length

        min_num = prices[0]
        for i in xrange(1, length):
          min_num = min(min_num, prices[i])
          left[i] = max(left[i - 1], prices[i] - min_num)

        max_num = prices[length - 1]
        for i in xrange(length - 2, -1, -1):
          max_num = max(max_num, prices[i])
          right[i] = max(right[i + 1], max_num - prices[i])

        res = float('-inf')
        for i in xrange(length):
          res = max(res, left[i] + right[i])

        return res
