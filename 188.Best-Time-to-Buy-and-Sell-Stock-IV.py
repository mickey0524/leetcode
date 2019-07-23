# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
#
# algorithms
# Hard (26.57%)
# Total Accepted:    92,107
# Total Submissions: 346,648


class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        length = len(prices)
        if length < 2:
            return 0

        if k > length / 2:
            return self.max_profit_inf(prices)

        dp = [[[0] * 2 for _ in xrange(k + 1)] for _ in xrange(length)]
        for i in xrange(length):
            for j in xrange(k, 0, -1):
                if i == 0:
                    dp[i][j][0] = 0
                    dp[i][j][1] = -prices[i]
                    continue

                dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
                dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1]
                                  [j - 1][0] - prices[i])

        return dp[length - 1][k][0]

    def max_profit_inf(self, prices):
        cur_0, cur_1 = 0, float('-inf')

        for n in prices:
            tmp = cur_0
            cur_0 = max(cur_0, cur_1 + n)
            cur_1 = max(cur_1, tmp - n)

        return cur_0
