# https://leetcode.com/problems/gray-code/
#
# algorithms
# Medium (44.97%)
# Total Accepted:    126,162
# Total Submissions: 281,168
# beats 95.52% of python submissions


class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        if n == 0:
            return [0]

        res = [0, 1]
        base = 2

        for _ in xrange(1, n):
            for n in reversed(res):
                res += base + n,
            base <<= 1

        return res


class Solution1(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        if n == 0:
            return [0]

        res = ['0', '1']
        zero_prefix = True

        for i in xrange(2, n + 1):
            tmp = []
            for n in res:
                if zero_prefix:
                    tmp += ['0' + n, '1' + n]
                else:
                    tmp += ['1' + n, '0' + n]
                zero_prefix = not zero_prefix
            res = tmp

        return [int(n, 2) for n in res]
