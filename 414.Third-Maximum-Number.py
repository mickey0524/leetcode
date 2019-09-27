# https://leetcode.com/problems/third-maximum-number/
#
# algorithms
# Easy (29.48%)
# Total Accepted:    105,393
# Total Submissions: 357,517


class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        st, nd, rd = float('-inf'), float('-inf'), float('-inf')

        for n in nums:
            if n > st:
                rd = nd
                nd = st
                st = n

            elif n == st:
                continue

            elif n > nd:
                rd = nd
                nd = n

            elif n == nd:
                continue

            elif n > rd:
                rd = n

        if rd == float('-inf'):
            return st

        return rd
