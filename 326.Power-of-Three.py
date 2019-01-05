# https://leetcode.com/problems/power-of-three/
#
# algorithms
# Easy (41.22%)
# Total Accepted:    160,981
# Total Submissions: 390,580

from math import log10

class Solution(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0:
            return False
        
        return (log10(n) / log10(3)) % 1 == 0