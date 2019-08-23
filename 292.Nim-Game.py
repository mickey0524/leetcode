# https://leetcode.com/problems/nim-game/
#
# algorithms
# Medium (55.8%)
# Total Accepted:    189,849
# Total Submissions: 340,261


class Solution(object):
    def canWinNim(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n % 4 == 0:
            return False

        return True
