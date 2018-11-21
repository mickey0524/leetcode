# https://leetcode.com/problems/minimum-falling-path-sum/description/
#
# algorithms
# Medium (55.79%)
# Total Accepted:    5.3k
# Total Submissions: 9.5k
# beats 86.75% of python submissions


class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        row = len(A)
        col = len(A[0])

        dp = [[0] * col for _ in xrange(row)]

        for i in xrange(col):
            dp[0][i] = A[0][i]

        for i in xrange(1, row):
            for j in xrange(col):
                min_path = dp[i - 1][j]
                if j > 0:
                    min_path = min(dp[i - 1][j - 1], dp[i - 1][j])
                if j < col - 1:
                    min_path = min(min_path, dp[i - 1][j + 1])
                dp[i][j] = min_path + A[i][j]

        return min(dp[row - 1])
