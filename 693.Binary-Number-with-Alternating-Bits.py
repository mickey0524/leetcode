# https://leetcode.com/problems/binary-number-with-alternating-bits/
#
# algorithms
# Easy (57.58%)
# Total Accepted:    37,884
# Total Submissions: 65,788
# beats 100.0% of python submissions


class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        s = bin(n)[2:]

        pre_ch = '-1'

        for ch in s:
            if ch == pre_ch:
                return False
            pre_ch = ch

        return True
