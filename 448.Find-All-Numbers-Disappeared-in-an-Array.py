# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
#
# algorithms
# Easy (53.99%)
# Total Accepted:    170,160
# Total Submissions: 315,198


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        length = len(nums)
        
        for i in xrange(length):
            if nums[i] == i + 1:
                continue
            
            j = i
            while nums[j] != j + 1:
                tmp = nums[nums[j] - 1]
                if tmp == nums[j]:
                    break
                    
                nums[nums[j] - 1] = nums[j]
                nums[j] = tmp
        
        res = []
        for i in xrange(length):
            if nums[i] != i + 1:
                res += (i + 1),
        
        return res
                