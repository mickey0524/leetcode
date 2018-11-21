# https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
#
# algorithms
# Easy (38.18%)
# Total Accepted:    458.2K
# Total Submissions: 1.2M

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        hash_map = {}
        idx = 0        

        for n in nums:
            if n not in hash_map:
                hash_map[n] = True
                nums[idx] = n
                idx += 1
        
        return idx