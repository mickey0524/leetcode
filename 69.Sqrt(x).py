# https://leetcode.com/problems/sqrtx/
#
# algorithms
# Easy (32.04%)
# Total Accepted:    412,756
# Total Submissions: 1,288,272


class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0:
            return 0

        l, r, m = 1, x, -1

        while l <= r:
            m = l + (r - l) / 2
            tmp = m * m

            if tmp == x:
                return m

            elif tmp > x:
                r = m - 1

            else:
                l = m + 1

        return l - 1
