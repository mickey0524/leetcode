# https://leetcode.com/problems/find-pivot-index/
#
# algorithms
# Easy (41.83%)
# Total Accepted:    83,546
# Total Submissions: 199,708


class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        right_sum, left_sum = sum(nums), 0
        
        for i in xrange(len(nums)):
            right_sum -= nums[i]
            if left_sum == right_sum:
                return i
        
            left_sum += nums[i]
        
        return -1
        