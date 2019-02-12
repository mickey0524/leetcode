# https://leetcode.com/problems/find-the-shortest-superstring/
#
# algorithms
# Hard (33.75%)
# Total Accepted:    2,515
# Total Submissions: 7,451
# beats 81.31% of python submissions
# greedy dfs


class Solution(object):
    def shortestSuperstring(self, A):
        """
        :type A: List[str]
        :rtype: str
        """
        length = len(A)
        same = [[0] * length for _ in xrange(length)]

        for i in xrange(length):
            for j in xrange(length):
                if i != j:
                    i_len, j_len = len(A[i]), len(A[j])
                    s = 0
                    for k in xrange(min(i_len, j_len)):
                        if A[i][i_len - 1 - k:] == A[j][:k + 1]:
                            s = max(s, k + 1)
                    same[i][j] = s

        is_visited = [False] * length
        res = [float('inf'), []]

        def recursive(idx, path, num, str_len):
            if str_len >= res[0]:
                return

            if num == length:
                if str_len < res[0]:
                    res[0] = str_len
                    res[1] = path[:]
                return

            is_found = False

            for i in xrange(length):
                if not is_visited[i] and same[idx][i] > 0:
                    is_visited[i] = True
                    is_found = True
                    recursive(i, path + [i], num + 1,
                              str_len + len(A[i]) - same[idx][i])
                    is_visited[i] = False

            if not is_found:
                for i in xrange(length):
                    if not is_visited[i]:
                        is_visited[i] = True
                        recursive(i, path + [i], num + 1, str_len + len(A[i]))
                        is_visited[i] = False

        for i in xrange(length):
            is_visited[i] = True
            recursive(i, [i], 1, len(A[i]))
            is_visited[i] = False

        res = res[1]
        res_str = A[res[0]]

        for i in xrange(1, length):
            res_str += A[res[i]][same[res[i - 1]][res[i]]:]

        return res_str
