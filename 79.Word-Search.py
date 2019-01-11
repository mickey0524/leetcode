# https://leetcode.com/problems/word-search/
#
# algorithms
# Medium (29.84%)
# Total Accepted:    236,278
# Total Submissions: 791,695


class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        def resursive(idx, i, j, is_visited):
            if res[0]:
                return
            if idx == word_len:
                res[0] = True
                return
            if i >= row or i < 0 or j >= col or j < 0:
                return

            if board[i][j] != word[idx] or is_visited[i][j]:
                return

            is_visited[i][j] = True
            resursive(idx + 1, i - 1, j, is_visited)
            resursive(idx + 1, i + 1, j, is_visited)
            resursive(idx + 1, i, j - 1, is_visited)
            resursive(idx + 1, i, j + 1, is_visited)
            is_visited[i][j] = False

        word_len = len(word)
        if word_len == 0:
            return False

        row = len(board)
        if row == 0:
            return False
        col = len(board[0])

        res = [False]

        for i in xrange(row):
            for j in xrange(col):
                is_visited = [[False] * col for _ in xrange(row)]
                if board[i][j] == word[0]:
                    resursive(0, i, j, is_visited)
                    if res[0]:
                        return True

        return False