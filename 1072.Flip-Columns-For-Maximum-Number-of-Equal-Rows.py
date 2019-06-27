# https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
# Medium (56.10%)
# Total Accepted:    3,989
# Total Submissions: 7,111


from collections import defaultdict


class Solution(object):
    def maxEqualRowsAfterFlips(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        row = len(matrix)
        if row == 0:
            return 0
        col = len(matrix[0])

        hash_map = defaultdict(int)
        res = 0

        for i in xrange(row):
            zero_col, one_col = [], []
            for j in xrange(col):
                if matrix[i][j] == 1:
                    one_col += j,
                else:
                    zero_col += j,

            zero_col_len, one_col_len = len(zero_col), len(one_col)

            if zero_col_len == 0 or one_col_len == 0:
                res += 1
            else:
                if zero_col_len == one_col_len:
                    hash_map[tuple(zero_col)] += 1
                    hash_map[tuple(one_col)] += 1
                elif zero_col_len < one_col_len:
                    hash_map[tuple(zero_col)] += 1
                else:
                    hash_map[tuple(one_col)] += 1

        if len(hash_map) == 0:
            return res

        return max(res, max(hash_map.values()))
