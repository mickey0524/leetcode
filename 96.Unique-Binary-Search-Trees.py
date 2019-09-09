# https://leetcode.com/problems/unique-binary-search-trees/
#
# algorithms
# Medium (47.61%)
# Total Accepted:    218,499
# Total Submissions: 458,895
# beats 88.72% of python submissions


class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 1

        for i in xrange(2, n + 1):
            for j in xrange(0, i):
                dp[i] += dp[j] * dp[i - j - 1]

        return dp[n]
