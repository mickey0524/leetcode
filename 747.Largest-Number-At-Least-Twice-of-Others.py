# https://leetcode.com/problems/largest-number-at-least-twice-of-others/
#
# algorithms
# Easy (40.8%)
# Total Accepted:    59,586
# Total Submissions: 146,035


class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        st, nd = float('-inf'), float('-inf')
        st_idx = -1

        for idx, n in enumerate(nums):
            if n > st:
                nd = st
                st, st_idx = n, idx

            elif n > nd:
                nd = n

        if st >= 2 * nd:
            return st_idx

        return -1
