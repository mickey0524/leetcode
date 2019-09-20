# https://leetcode.com/problems/valid-perfect-square/
#
# algorithms
# Easy (40.4%)
# Total Accepted:    125,369
# Total Submissions: 310,341


class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        l, r, m = 1, num, -1

        while l <= r:
            m = l + (r - l) / 2
            tmp = m * m

            if tmp == num:
                return True

            if tmp < num:
                l = m + 1

            else:
                r = m - 1

        return False
