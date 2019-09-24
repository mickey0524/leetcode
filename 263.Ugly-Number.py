# https://leetcode.com/problems/ugly-number/
#
# algorithms
# Easy (40.94%)
# Total Accepted:    170,226
# Total Submissions: 415,815


class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False

        while num & 1 == 0:
            num >>= 1

        while num % 3 == 0:
            num /= 3

        while num % 5 == 0:
            num /= 5

        return num == 1
