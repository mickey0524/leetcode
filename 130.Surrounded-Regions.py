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


class Solution1(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        row = len(board)
        if row == 0:
            return
        col = len(board[0])

        def recursive(i, j):
            board[i][j] = 'A'
            if i > 0 and board[i - 1][j] == 'O':
                recursive(i - 1, j)

            if i < row - 1 and board[i + 1][j] == 'O':
                recursive(i + 1, j)

            if j > 0 and board[i][j - 1] == 'O':
                recursive(i, j - 1)

            if j < col - 1 and board[i][j + 1] == 'O':
                recursive(i, j + 1)

        for i in xrange(row):
            if board[i][0] == 'O':
                recursive(i, 0)

            if board[i][col - 1] == 'O':
                recursive(i, col - 1)

        for i in xrange(col):
            if board[0][i] == 'O':
                recursive(0, i)

            if board[row - 1][i] == 'O':
                recursive(row - 1, i)

        for i in xrange(row):
            for j in xrange(col):
                if board[i][j] == 'O':
                    board[i][j] = 'X'

        for i in xrange(row):
            for j in xrange(col):
                if board[i][j] == 'A':
                    board[i][j] = 'O'
