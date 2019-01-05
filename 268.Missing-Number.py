# https://leetcode.com/problems/missing-number/
#
# algorithms
# Easy (46.93%)
# Total Accepted:    230,300
# Total Submissions: 490,714

class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        s = sum(nums)
        
        if s == (length - 1) * length / 2:
            return length
        
        return (length * (length + 1) / 2) - s
                    