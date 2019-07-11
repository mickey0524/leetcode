# https://leetcode.com/problems/valid-sudoku/
#
# algorithms
# Medium (43.66%)
# Total Accepted:    246,867
# Total Submissions: 565,463
# beats 74.62% of python submissions


class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for i in xrange(9):
            is_visited = [False] * 9
            for j in xrange(9):
                if board[i][j] == '.':
                    continue
                if is_visited[int(board[i][j]) - 1]:
                    return False
                is_visited[int(board[i][j]) - 1] = True

            is_visited = [False] * 9
            for j in xrange(9):
                if board[j][i] == '.':
                    continue
                if is_visited[int(board[j][i]) - 1]:
                    return False
                is_visited[int(board[j][i]) - 1] = True

        for i in xrange(3):
            for j in xrange(3):
                is_visited = [False] * 9
                for k in xrange(i * 3, i * 3 + 3):
                    for l in xrange(j * 3, j * 3 + 3):
                        if board[k][l] == '.':
                            continue
                        if is_visited[int(board[k][l]) - 1]:
                            return False
                        is_visited[int(board[k][l]) - 1] = True

        return True
