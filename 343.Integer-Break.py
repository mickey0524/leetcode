# https://leetcode.com/problems/integer-break/
#
# algorithms
# Medium (47.32%)
# Total Accepted:    73,793
# Total Submissions: 155,947


class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 2:
            return 1

        dp = [0] * (n + 1)
        dp[1] = 1
        dp[2] = 1

        for i in xrange(3, n + 1):
            cur_max = -1
            for j in xrange(1, i):
                cur_max = max(cur_max, max(dp[j], j) * max(dp[i - j], i - j))
            dp[i] = cur_max

        return dp[-1]
