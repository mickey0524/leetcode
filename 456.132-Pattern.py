# https://leetcode.com/problems/132-pattern/
#
# algorithms
# Medium (27.38%)
# Total Accepted:    27,010
# Total Submissions: 98,634


class Solution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        
        if length < 3:
            return False
        
        stack = []
        right = float('-inf')
        
        for i in xrange(length - 1, -1, -1):
            if nums[i] < right:
                return True
            
            while stack and nums[i] > stack[-1]:
                right = stack.pop()
            stack.append(nums[i])
        
        return False
        
        
                
                
                