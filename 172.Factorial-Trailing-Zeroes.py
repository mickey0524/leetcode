# https://leetcode.com/problems/factorial-trailing-zeroes/
#
# algorithms
# Easy (37.09%)
# Total Accepted:    140,770
# Total Submissions: 379,570


class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = 0

        while n > 0:
            n /= 5
            res += n

        return res
