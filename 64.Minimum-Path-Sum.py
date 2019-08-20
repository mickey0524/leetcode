# https://leetcode.com/problems/minimum-path-sum/
#
# algorithms
# Medium (48.15%)
# Total Accepted:    252,300
# Total Submissions: 523,948


class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        if m == 0:
            return 0

        n = len(grid[0])
        dp = [[0] * n for _ in xrange(m)]
        dp[0][0] = grid[0][0]

        for i in xrange(1, n):
            dp[0][i] = dp[0][i - 1] + grid[0][i]

        for i in xrange(1, m):
            dp[i][0] += dp[i - 1][0] + grid[i][0]

        for i in xrange(1, m):
            for j in xrange(1, n):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

        return dp[-1][-1]
