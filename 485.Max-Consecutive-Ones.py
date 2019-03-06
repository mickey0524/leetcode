# https://leetcode.com/problems/max-consecutive-ones/
#
# algorithms
# Easy (54.52%)
# Total Accepted:    124,735
# Total Submissions: 228,773
# beats 100.0% of python submissions


class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        cur_ones = 0

        for n in nums:
            if n == 1:
                cur_ones += 1
            else:
                res = max(res, cur_ones)
                cur_ones = 0

        return max(res, cur_ones)
