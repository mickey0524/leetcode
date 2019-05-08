# https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
#
# algorithms
# Hard (39.80%)
# Total Accepted:    84,849
# Total Submissions: 213,186


class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        row = len(matrix)
        if row == 0:
            return 0
        col = len(matrix[0])
        res = [float('-inf')]
        dp = [[0] * col for _ in xrange(row)]

        def recursive(i, j):
            if dp[i][j] > 0:
                return dp[i][j]

            cur_max = 0

            if i > 0 and matrix[i - 1][j] > matrix[i][j]:
                cur_max = max(recursive(i - 1, j), cur_max)

            if i < row - 1 and matrix[i + 1][j] > matrix[i][j]:
                cur_max = max(recursive(i + 1, j), cur_max)

            if j > 0 and matrix[i][j - 1] > matrix[i][j]:
                cur_max = max(recursive(i, j - 1), cur_max)

            if j < col - 1 and matrix[i][j + 1] > matrix[i][j]:
                cur_max = max(recursive(i, j + 1), cur_max)

            dp[i][j] = cur_max + 1

            return dp[i][j]

        res = 1
        for i in xrange(row):
            for j in xrange(col):
                res = max(recursive(i, j), res)

        return res
