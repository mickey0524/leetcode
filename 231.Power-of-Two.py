# https://leetcode.com/problems/basic-calculator-ii/description/
#
# algorithms
# Easy (41.49%)
# Total Accepted:    207,010
# Total Submissions: 498,902

class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0:
            return False
        return (math.log10(n) / math.log10(2)) % 1 == 0
