# https://leetcode.com/problems/sudoku-solver/
#
# algorithms
# Hard (35.58%)
# Total Accepted:    118,165
# Total Submissions: 332,037
# beats 75.0% of python submissions


class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        row_is_used = [[False] * 10 for _ in xrange(9)]
        col_is_used = [[False] * 10 for _ in xrange(9)]
        sub_box_is_used = [[False] * 10 for _ in xrange(9)]
        need_fill = []

        for i in xrange(9):
            for j in xrange(9):
                if board[i][j] != '.':
                    row_is_used[i][int(board[i][j])] = True
                    col_is_used[j][int(board[i][j])] = True
                    sub_box_is_used[self.get_sub_box_idx(
                        i, j)][int(board[i][j])] = True
                else:
                    need_fill += (i, j),

        length = len(need_fill)
        is_found = [False]

        def recursive(idx):
            if is_found[0]:
                return

            if idx == length:
                is_found[0] = True
                return

            i, j = need_fill[idx]
            for n in xrange(1, 10):
                sub_box_idx = self.get_sub_box_idx(i, j)
                if not row_is_used[i][n] and not col_is_used[j][n] and not sub_box_is_used[sub_box_idx][n]:
                    row_is_used[i][n] = True
                    col_is_used[j][n] = True
                    sub_box_is_used[sub_box_idx][n] = True
                    board[i][j] = str(n)
                    recursive(idx + 1)
                    if is_found[0]:
                        return
                    board[i][j] = '.'
                    row_is_used[i][n] = False
                    col_is_used[j][n] = False
                    sub_box_is_used[sub_box_idx][n] = False

        recursive(0)

    def get_sub_box_idx(self, i, j):
        if 0 <= i < 3:
            if 0 <= j < 3:
                return 0
            if 3 <= j < 6:
                return 1
            else:
                return 2

        if 3 <= i < 6:
            if 0 <= j < 3:
                return 3
            if 3 <= j < 6:
                return 4
            else:
                return 5

        if 0 <= j < 3:
            return 6
        if 3 <= j < 6:
            return 7

        return 8
