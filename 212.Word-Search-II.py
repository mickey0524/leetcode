# https://leetcode.com/problems/word-search-ii/
#
# algorithms
# Hard (27.72%)
# Total Accepted:    100,953
# Total Submissions: 364,212
# beats 61.83% of python submissions


class TrieNode(object):
    def __init__(self):
        self.children = [None] * 26
        self.is_leaf = False


class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        trie_root = TrieNode()
        row, col = len(board), len(board[0])

        for w in words:
            tmp = trie_root
            for ch in w:
                trie_idx = ord(ch) - 97
                if tmp.children[trie_idx] is None:
                    tmp.children[trie_idx] = TrieNode()
                tmp = tmp.children[trie_idx]
            tmp.is_leaf = True

        def recursive(i, j, root, path):
            ch = board[i][j]

            if ch == '#':
                return

            trie_idx = ord(ch) - 97
            if root.children[trie_idx] is None:
                return

            path += ch
            board[i][j] = '#'
            if root.children[trie_idx].is_leaf:
                res[0] += path,
                root.children[trie_idx].is_leaf = False

            if i > 0:
                recursive(i - 1, j, root.children[trie_idx], path)

            if i < row - 1:
                recursive(i + 1, j, root.children[trie_idx], path)

            if j > 0:
                recursive(i, j - 1, root.children[trie_idx], path)

            if j < col - 1:
                recursive(i, j + 1, root.children[trie_idx], path)

            path = path[:-1]
            board[i][j] = ch

        res = [[]]

        for i in xrange(row):
            for j in xrange(col):
                    recursive(i, j, trie_root, '')

        return res[0]
