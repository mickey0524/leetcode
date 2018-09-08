# https://leetcode.com/problems/magic-squares-in-grid/description/
#
# algorithms
# Easy (42.6%)
# Total Accepted:    6.5k
# Total Submissions: 18.9k
# beats 34.39% of python submissions


class Solution(object):
    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row = len(grid)
        column = len(grid[0])
        res = 0

        if row < 3 or column < 3:
            return 0

        for i in xrange(row - 2):
            for j in xrange(column - 2):
                same_sum = sum(grid[i][j: j + 3])

                if grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != same_sum or \
                        grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] != same_sum:
                    continue
                column_sum = [0] * 3
                arr = []

                is_error = False
                for k in xrange(i, i + 3):
                    line_sum = 0
                    for l in xrange(j, j + 3):
                        column_sum[l - j] += grid[k][l]
                        line_sum += grid[k][l]
                        if grid[k][l] >= 10 or grid[k][l] == 0 or grid[k][l] in arr:
                            is_error = True
                            break
                        else:
                            arr += grid[k][l],
                    if is_error or line_sum != same_sum:
                        break

                if len(set(column_sum) | set([same_sum])) > 1:
                    continue
                res += 1

        return res
