# https://leetcode.com/problems/minesweeper/
#
# algorithms
# Medium (51.57%)
# Total Accepted:    27,847
# Total Submissions: 54,000
# beats 100.0% of python submissions

class Solution(object):
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        if board[click[0]][click[1]] == 'M':
            board[click[0]][click[1]] = 'X'
            return board

        row, col = len(board), len(board[0])

        def resursive(i, j):
            if i < 0 or i >= row or j < 0 or j >= col:
                return

            mine_num = 0

            for x in xrange(max(0, i - 1), min(i + 2, row)):
                for y in xrange(max(0, j - 1), min(j + 2, col)):
                    if board[x][y] == 'M':
                        mine_num += 1

            if mine_num > 0:
                board[i][j] = str(mine_num)
                return

            board[i][j] = 'B'

            for x in xrange(max(0, i - 1), min(i + 2, row)):
                for y in xrange(max(0, j - 1), min(j + 2, col)):
                    if board[x][y] == 'E':
                        resursive(x, y)

        resursive(click[0], click[1])

        return board
