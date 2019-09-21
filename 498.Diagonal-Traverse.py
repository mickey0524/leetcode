# https://leetcode.com/problems/find-mode-in-binary-search-tree/
#
# algorithms
# Easy (45.87%)
# Total Accepted:    50,117
# Total Submissions: 109,247
# beats 100.0% of python submissions


class Solution(object):
    def findDiagonalOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        row = len(matrix)
        if row == 0:
            return []
        col = len(matrix[0])

        i, j = 0, 0
        is_top = True
        res = []

        for _ in xrange(row * col):
            res.append(matrix[i][j])

            if is_top:
                if i - 1 < 0 or j + 1 >= col:
                    if j + 1 == col:
                        i += 1
                    else:
                        j += 1

                    is_top = False
                else:
                    i -= 1
                    j += 1

            else:
                if i + 1 >= row or j - 1 < 0:
                    if i + 1 == row:
                        j += 1
                    else:
                        i += 1

                    is_top = True
                else:
                    i += 1
                    j -= 1

        return res
