# https://leetcode.com/problems/available-captures-for-rook/
# Easy (76.3%)
# Total Accepted:    2,857
# Total Submissions: 3,744
# beats 100.0% of python submissions


class Solution(object):
    def numRookCaptures(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        x, y = -1, -1
        for i in xrange(8):
            for j in xrange(8):
                if board[i][j] == 'R':
                    x, y = i, j
                    break

        res = 0

        for x_step, y_step in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            i, j = x + x_step, y + y_step
            while i > -1 and i < 8 and j > -1 and j < 8:
                if board[i][j] == 'B':
                    break
                if board[i][j] == 'p':
                    res += 1
                    break
                i, j = i + x_step, j + y_step

        return res
