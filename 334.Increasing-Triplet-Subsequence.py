# https://leetcode.com/problems/increasing-triplet-subsequence/
#
# algorithms
# Medium (39.50%)
# Total Accepted:    90,035
# Total Submissions: 227,920


class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        if length < 3:
            return False

        first, second = float('inf'), float('inf')

        for n in nums:
            if n <= first:
                first = n
            elif n < second:
                second = n
            elif n > second:
                return True

        return False
