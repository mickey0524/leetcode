# https://leetcode.com/problems/surrounded-regions/description/
#
# algorithms
# Medium (21.17%)
# Total Accepted:    121.7K
# Total Submissions: 574.7K


class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        row = len(board)
        if row <= 2:
            return
        col = len(board[0])
        if col <= 2:
            return

        self.is_visited = [[False] * col for _ in xrange(row)]

        for i in xrange(row):
            for j in xrange(col):
                if board[i][j] == 'O' and not self.is_visited[i][j]:
                    self.path = []
                    self.is_board = False
                    self.resursive(i, j, board, row, col)
                    if not self.is_board:
                        for x, y in self.path:
                            board[x][y] = 'X'

        return

    def resursive(self, x, y, board, row, col):
        self.is_visited[x][y] = True
        self.path += (x, y),

        if x == 0 or x == row - 1 or y == 0 or y == col - 1:
            self.is_board = True

        if x > 0 and board[x - 1][y] == 'O' and not self.is_visited[x - 1][y]:
            self.resursive(x - 1, y, board, row, col)
        if x < row - 1 and board[x + 1][y] == 'O' and not self.is_visited[x + 1][y]:
            self.resursive(x + 1, y, board, row, col)
        if y > 0 and board[x][y - 1] == 'O' and not self.is_visited[x][y - 1]:
            self.resursive(x, y - 1, board, row, col)
        if y < col - 1 and board[x][y + 1] == 'O' and not self.is_visited[x][y + 1]:
            self.resursive(x, y + 1, board, row, col)
