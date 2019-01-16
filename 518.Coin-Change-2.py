# https://leetcode.com/problems/coin-change-2/
#
# algorithms
# Medium (40.38%)
# Total Accepted:    32,169
# Total Submissions: 79,662
# beats 97.92% of python submissions


class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [0] * (amount + 1)
        dp[0] = 1

        for c in coins:
            for i in xrange(amount - c + 1):
                dp[i + c] += dp[i]

        return dp[-1]