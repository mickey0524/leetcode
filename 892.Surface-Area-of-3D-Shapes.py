# https://leetcode.com/problems/surface-area-of-3d-shapes/description/
#
# algorithms
# Esay (56.2%)
# Total Accepted:    1.6k
# Total Submissions: 2.9k


class Solution(object):
    def surfaceArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        N = len(grid)
        if N == 1:
            return 0 if grid[0][0] == 0 else 2 + grid[0][0] * 4

        res = 0

        for i in xrange(N):
            for j in xrange(N):
                if grid[i][j] != 0:
                    res += 2
                if i == 0 or i == N - 1:
                    res += grid[i][j]
                if j == 0 or j == N - 1:
                    res += grid[i][j]
                if i > 0:
                    res += abs(grid[i][j] - grid[i - 1][j])
                if j > 0:
                    res += abs(grid[i][j] - grid[i][j - 1])

        return int(res)
