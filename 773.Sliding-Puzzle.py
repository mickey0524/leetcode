# https://leetcode.com/problems/sliding-puzzle/
#
# algorithms
# Hard (51.26%)
# Total Accepted:    13,787
# Total Submissions: 26,895

from collections import deque
from copy import deepcopy


class Solution(object):
    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        if self.equals(board):
            return 0

        zero_idx = None
        for i in xrange(2):
            for j in xrange(3):
                if board[i][j] == 0:
                    zero_idx = (i, j)
                    break

        q = deque([(board, zero_idx), ('#', -1)])
        s = set()
        s.add(self.gen_str(board))
        res = 0

        while q:
            b, zero_idx = q.popleft()
            if b == '#':
                if not q:
                    break
                q.append(('#', -1))
                res += 1
            else:
                for diff in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    x, y = zero_idx[0] + diff[0], zero_idx[1] + diff[1]
                    if 0 <= x <= 1 and 0 <= y <= 2:
                        c = deepcopy(b)
                        c[x][y], c[zero_idx[0]][zero_idx[1]
                                                ] = c[zero_idx[0]][zero_idx[1]], c[x][y]
                        if self.equals(c):
                            return res + 1
                        k = self.gen_str(c)
                        if k not in s:
                            q.append((c, (x, y)))
                            s.add(k)

        return -1

    def equals(self, a):
        solved = [[1, 2, 3], [4, 5, 0]]

        for i in xrange(2):
            for j in xrange(3):
                if a[i][j] != solved[i][j]:
                    return False

        return True

    def gen_str(self, a):
        res = ''

        for i in xrange(2):
            for j in xrange(3):
                res += str(a[i][j])

        return res

# 我的方法过于复杂了，其实直接将数组转为字符串就能做了，然后根据0在字符串中的下标来决定0能够转移到哪个下标，用一个
# hash 表存储即可，没有必要去遍历

class Solution1(object):

    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        moves = {0: {1, 3}, 1: {0, 2, 4}, 2: {1, 5},
                 3: {0, 4}, 4: {1, 3, 5}, 5: {2, 4}}
        used = set()
        cnt = 0

        s = ''.join([str(c) for row in board for c in row])
        q = [(s, s.index('0'))]
        while q:
            new = []
            for s, i in q:
                if s == '123450':
                    return cnt
                used.add(s)
                arr = [c for c in s]
                for move in moves[i]:
                    new_arr = arr[:]
                    tmp = new_arr[move]
                    new_arr[move] = new_arr[i]
                    new_arr[i] = tmp
                    new_str = ''.join(new_arr)
                    if new_str not in used:
                        new.append((new_str, move))
            cnt += 1
            q = new
        return -1
