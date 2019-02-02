# https://leetcode.com/problems/bulb-switcher-ii/
#
# algorithms
# Medium (49.27%)
# Total Accepted:    8,378
# Total Submissions: 17,003
# beats 100.0% of python submissions


class Solution(object):
    def flipLights(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        if m == 0: return 1
        if n == 1: return 2
        if n == 2:
            if m == 1: return 3
            return 4
        if n >= 3:
            if m == 1: return 4
            if m == 2: return 7        
    
        return 8
    