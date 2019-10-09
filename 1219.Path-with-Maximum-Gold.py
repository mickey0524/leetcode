# https://leetcode.com/problems/path-with-maximum-gold/
# Medium (60.26%)
# Total Accepted:    4,845
# Total Submissions: 8,040
# beats 100.0 % of python submissions


class Solution(object):
    def getMaximumGold(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row, col = len(grid), len(grid[0])

        is_visited = [[False] * col for _ in xrange(row)]
        max_gold = [float('-inf')]

        def recursive(i, j, cur_gold):
            max_gold[0] = max(max_gold[0], cur_gold)

            if i > 0 and grid[i - 1][j] != 0 and not is_visited[i - 1][j]:
                is_visited[i - 1][j] = True
                recursive(i - 1, j, cur_gold + grid[i - 1][j])
                is_visited[i - 1][j] = False

            if i < row - 1 and grid[i + 1][j] != 0 and not is_visited[i + 1][j]:
                is_visited[i + 1][j] = True
                recursive(i + 1, j, cur_gold + grid[i + 1][j])
                is_visited[i + 1][j] = False

            if j > 0 and grid[i][j - 1] != 0 and not is_visited[i][j - 1]:
                is_visited[i][j - 1] = True
                recursive(i, j - 1, cur_gold + grid[i][j - 1])
                is_visited[i][j - 1] = False

            if j < col - 1 and grid[i][j + 1] != 0 and not is_visited[i][j + 1]:
                is_visited[i][j + 1] = True
                recursive(i, j + 1, cur_gold + grid[i][j + 1])
                is_visited[i][j + 1] = False

        for i in xrange(row):
            for j in xrange(col):
                if grid[i][j] != 0:
                    is_visited[i][j] = True
                    recursive(i, j, grid[i][j])
                    is_visited[i][j] = False

        return max_gold[0]
