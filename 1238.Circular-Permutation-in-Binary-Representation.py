# https://leetcode.com/problems/circular-permutation-in-binary-representation/
# Medium (53.14%)
# Total Accepted:    2,527
# Total Submissions: 4,755


class Solution(object):
    def circularPermutation(self, n, start):
        """
        :type n: int
        :type start: int
        :rtype: List[int]
        """
        if n == 1:
            return [0, 1] if start == 0 else [1, 0]

        res = ['0', '1']
        for i in xrange(2, n + 1):
            zero_begin, one_begin = [], []
            for s in res:
                zero_begin.append('0' + s)
                one_begin.append('1' + s)

            res = one_begin[::-1] + zero_begin

        pivot = -1
        for idx, s in enumerate(res):
            tmp = int(s, 2)
            if tmp == start:
                pivot = idx

            res[idx] = tmp

        return res[pivot:] + res[:pivot]
