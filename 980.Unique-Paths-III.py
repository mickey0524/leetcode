# https://leetcode.com/problems/unique-paths-iii/
# Hard (72.23%)
# Total Accepted:    5,837
# Total Submissions: 8,081
# beats 71.13% of python submissions


class Solution(object):
    def uniquePathsIII(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row, col = len(grid), len(grid[0])

        start, end = None, None
        nb_set = set()

        for i in xrange(row):
            for j in xrange(col):
                if grid[i][j] == 1:
                    start = (i, j)
                elif grid[i][j] == 2:
                    end = (i, j)
                    nb_set.add((i, j))
                elif grid[i][j] == 0:
                    nb_set.add((i, j))

        if not start or not end:
            return 0

        res = [0]

        def recursive(x, y):
            if x == end[0] and y == end[1]:
                if len(nb_set) == 0:
                    res[0] += 1
                return

            if x > 0 and grid[x - 1][y] != 1 and (x - 1, y) in nb_set:
                nb_set.remove((x - 1, y))
                recursive(x - 1, y)
                nb_set.add((x - 1, y))

            if x < row - 1 and grid[x + 1][y] != 1 and (x + 1, y) in nb_set:
                nb_set.remove((x + 1, y))
                recursive(x + 1, y)
                nb_set.add((x + 1, y))

            if y > 0 and grid[x][y - 1] != 1 and (x, y - 1) in nb_set:
                nb_set.remove((x, y - 1))
                recursive(x, y - 1)
                nb_set.add((x, y - 1))

            if y < col - 1 and grid[x][y + 1] != 1 and (x, y + 1) in nb_set:
                nb_set.remove((x, y + 1))
                recursive(x, y + 1)
                nb_set.add((x, y + 1))

        recursive(start[0], start[1])

        return res[0]
