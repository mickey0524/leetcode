# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
#
# algorithms
# Medium (49.47%)
# Total Accepted:    34,319
# Total Submissions: 69,379
# beats 100.0% of python submissions


class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        length = len(prices)
        if length < 2:
            return 0

        res = 0
        buy = prices[0]
        for n in prices:
            if n < buy:
                buy = n
            else:
                tmp = n - buy - fee
                if tmp > 0:
                    res += tmp
                    buy = n - fee

        return res


class Solution1(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        length = len(prices)
        if length < 2:
            return 0

        cur_0, cur_1 = 0, float('-inf')

        for n in prices:
            tmp = cur_0
            cur_0 = max(cur_0, cur_1 + n - fee)
            cur_1 = max(cur_1, tmp - n)

        return cur_0
