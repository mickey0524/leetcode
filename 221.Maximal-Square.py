# https://leetcode.com/problems/maximal-square/
#
# algorithms
# Medium (31.8%)
# Total Accepted:    111,987
# Total Submissions: 352,150


class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        row = len(matrix)
        if row == 0:
            return 0
        col = len(matrix[0])

        res = 0

        for i in xrange(row):
            for j in xrange(col):
                if matrix[i][j] == '1':
                    side = 1
                    is_ok = True
                    while True:
                        if i + side >= row or j + side >= col:
                            is_ok = False
                            break

                        for k in xrange(i, i + side + 1):
                            if matrix[k][j + side] == '0':
                                is_ok = False
                                break

                        for k in xrange(j, j + side + 1):
                            if matrix[i + side][k] == '0':
                                is_ok = False
                                break

                        if not is_ok:
                            break

                        side += 1

                    square = side * side
                    res = max(res, square)

        return res

# 我的方法比较暴力，AC 之后发现其实这是一道 DP 的问题
# 记录下每个点最长的边，取最小值

class Solution1(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or not matrix[0]:
            return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        curMax = 0
        for i in xrange(1, m + 1):
            for j in xrange(1, n + 1):
                if matrix[i - 1][j - 1] == '1':
                    upperLeft = dp[i - 1][j - 1]
                    left = dp[i][j - 1]
                    up = dp[i - 1][j]
                    dp[i][j] = min(upperLeft, left, up) + 1
                    curMax = max(curMax, dp[i][j])
        return curMax * curMax
