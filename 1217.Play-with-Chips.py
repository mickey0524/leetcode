# https://leetcode.com/problems/play-with-chips/
# Easy (61.66%)
# Total Accepted:    5,251
# Total Submissions: 8,516
# beats 100.0 % of python submissions


class Solution(object):
    def minCostToMoveChips(self, chips):
        """
        :type chips: List[int]
        :rtype: int
        """
        odd, even = 0, 0
        for n in chips:
            if n & 1 == 0:
                even += 1
            else:
                odd += 1

        return min(even, odd)
