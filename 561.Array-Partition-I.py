# https://leetcode.com/problems/array-partition-i/
#
# algorithms
# Medium (70.00%)
# Total Accepted:    164,554
# Total Submissions: 235,101


class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        nums.sort()

        res = 0
        for i in xrange(0, length, 2):
            res += nums[i]

        return res
