# https://leetcode.com/problems/optimal-division/
#
# algorithms
# Easy (54.99%)
# Total Accepted:    18,823
# Total Submissions: 34,228
# beats 100.0% of python submissions

class Solution(object):
    def optimalDivision(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        length = len(nums)
        if length == 1:
            return str(nums[0])
        if length == 2:
            return str(nums[0]) + '/' + str(nums[1])
        
        s = str(nums[0]) + '/('
        for n in nums[1:]:
            s += str(n) + '/'
        
        s = s[:-1]
        s += ')'
        
        return s
        