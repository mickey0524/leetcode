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


# 效率高很多
class Solution1(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        def recursive(i, j, idx):
            if res[0]:
                return True

            if idx == word_len:
                res[0] = True
                return True

            r = False

            if i > 0 and board[i - 1][j] == word[idx] and (i - 1, j) not in is_visited:
                is_visited[(i - 1, j)] = True
                tmp = recursive(i - 1, j, idx + 1)
                r |= tmp
                del is_visited[(i - 1, j)]

            if i < row - 1 and board[i + 1][j] == word[idx] and (i + 1, j) not in is_visited:
                is_visited[(i + 1, j)] = True
                tmp = recursive(i + 1, j, idx + 1)
                r |= tmp
                del is_visited[(i + 1, j)]

            if j > 0 and board[i][j - 1] == word[idx] and (i, j - 1) not in is_visited:
                is_visited[(i, j - 1)] = True
                tmp = recursive(i, j - 1, idx + 1)
                r |= tmp
                del is_visited[(i, j - 1)]

            if j < col - 1 and board[i][j + 1] == word[idx] and (i, j + 1) not in is_visited:
                is_visited[(i, j + 1)] = True
                tmp = recursive(i, j + 1, idx + 1)
                r |= tmp
                del is_visited[(i, j + 1)]

            return r

        res = [False]
        word_len = len(word)
        row, col = len(board), len(board[0])

        for i in xrange(row):
            for j in xrange(col):
                if board[i][j] == word[0]:
                    is_visited = {(i, j): True}
                    if recursive(i, j, 1):
                        return True

        return False
