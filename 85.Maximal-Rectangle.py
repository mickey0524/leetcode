# https://leetcode.com/problems/maximal-rectangle/
#
# algorithms
# Hard (34.26%)
# Total Accepted:    131,671
# Total Submissions: 384,286


class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        row = len(matrix)
        if row == 0:
            return 0
        col = len(matrix[0])
        res = 0

        flag = [[[0] * 2 for _ in xrange(col)] for _ in xrange(row)]
        for i in xrange(row):
            for j in xrange(col):
                if matrix[i][j] == '0':
                    continue

                else:
                    if i == 0:
                        flag[i][j][1] = 1
                    else:
                        flag[i][j][1] = 1 + flag[i - 1][j][1]

                    if j == 0:
                        flag[i][j][0] = 1
                    else:
                        flag[i][j][0] = 1 + flag[i][j - 1][0]

                width = flag[i][j][0]
                area = flag[i][j][0]
                for k in xrange(1, flag[i][j][1]):
                    width = min(width, flag[i - k][j][0])
                    area = max(area, width * (k + 1))

                res = max(res, area)

        flag = [[[0] * 2 for _ in xrange(col)] for _ in xrange(row)]
        for i in xrange(row - 1, -1, -1):
            for j in xrange(col - 1, -1, -1):
                if matrix[i][j] == '0':
                    continue

                else:
                    if i == row - 1:
                        flag[i][j][1] = 1
                    else:
                        flag[i][j][1] = 1 + flag[i + 1][j][1]

                    if j == col - 1:
                        flag[i][j][0] = 1
                    else:
                        flag[i][j][0] = 1 + flag[i][j + 1][0]

                width = flag[i][j][0]
                area = flag[i][j][0]
                for k in xrange(1, flag[i][j][1]):
                    width = min(width, flag[i + k][j][0])
                    area = max(area, width * (k + 1))

                res = max(res, area)

        return res
