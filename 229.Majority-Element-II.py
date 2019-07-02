# https://leetcode.com/problems/majority-element-ii/
#
# algorithms
# Medium (32.37%)
# Total Accepted:    103,787
# Total Submissions: 320,671
# beats 100.0% of python submissions

class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        length = len(nums)
        if length == 0:
            return []
        
        threshold = length / 3
        n1, n2, c1, c2 = nums[0], nums[0], 0, 0
        
        for n in nums:
            if n == n1:
                c1 += 1
            elif n == n2:
                c2 += 1
            elif c1 == 0:
                n1 = n
                c1 = 1
            elif c2 == 0:
                n2 = n
                c2 = 1
            else:
                c1 -= 1
                c2 -= 1
        
        c1, c2 = 0, 0
        for n in nums:
            if n == n1:
                c1 += 1
            elif n == n2:
                c2 += 1
        
        res = []
        if c1 > threshold:
            res += n1,
        if c2 > threshold:
            res += n2,
        
        return res
        