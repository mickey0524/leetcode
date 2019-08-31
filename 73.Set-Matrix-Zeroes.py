# https://leetcode.com/problems/set-matrix-zeroes/
#
# algorithms
# Medium (40.66%)
# Total Accepted:    230,911
# Total Submissions: 567,876


class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        if m == 0:
            return
        n = len(matrix[0])

        for i in xrange(m):
            for j in xrange(n):
                if matrix[i][j] == 0:
                    if j == 0 and matrix[0][j] == float('inf'):
                        matrix[0][0] = 0
                    elif matrix[0][j] != 0:
                        matrix[0][j] = float('-inf')

                    if i == 0 and matrix[i][0] == float('-inf'):
                        matrix[0][0] = 0
                    elif matrix[i][0] != 0:
                        matrix[i][0] = float('inf')

        for j in xrange(n):
            if j != 0 and (matrix[0][j] == float('-inf') or matrix[0][j] == 0):
                for i in xrange(1, m):
                    matrix[i][j] = 0

        for i in xrange(m):
            if i != 0 and (matrix[i][0] == float('inf') or matrix[i][0] == 0):
                for j in xrange(1, n):
                    matrix[i][j] = 0

        if matrix[0][0] == 0 or matrix[0][0] == float('-inf'):
            for i in xrange(1, m):
                matrix[i][0] = 0

        if matrix[0][0] == 0 or matrix[0][0] == float('inf'):
            for i in xrange(1, n):
                matrix[0][i] = 0

        for i in xrange(m):
            if matrix[i][0] == float('inf'):
                matrix[i][0] = 0

        for i in xrange(n):
            if matrix[0][i] == float('-inf'):
                matrix[0][i] = 0
