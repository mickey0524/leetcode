# https://leetcode.com/problems/magic-squares-in-grid/description/
#
# algorithms
# Medium (35.25%)
# Total Accepted:    12,752
# Total Submissions: 36,179
# beats 66.41% of python submissions


class Solution(object):
    def splitIntoFibonacci(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        length = len(S)
        if length < 3:
            return []

        res = [[]]
        threshold = 2 ** 31 - 1

        def recursive(idx, path):
            if res[0]:
                return

            if idx == length:
                if len(path) >= 3:
                    res[0] = path[:]

                return

            if S[idx] == '0':
                if len(path) < 2 or path[-1] + path[-2] == 0:
                    recursive(idx + 1, path + [0])

                return

            for i in xrange(idx, length):
                tmp = int(S[idx:i + 1])
                if tmp > threshold:
                    break

                if len(path) < 2:
                    recursive(i + 1, path + [tmp])

                elif path[-1] + path[-2] == tmp:
                    recursive(i + 1, path + [tmp])

                elif path[-1] + path[-2] < tmp:
                    break

        recursive(0, [])

        return res[0]
