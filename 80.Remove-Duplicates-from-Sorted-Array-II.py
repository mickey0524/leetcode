# https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
#
# algorithms
# Medium (38.63%)
# Total Accepted:    175.3K
# Total Submissions: 453.8K

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        hash_map = {}
        idx = 0
        
        for n in nums:
            if n not in hash_map or hash_map[n] == 1:
                hash_map[n] = hash_map.get(n, 0) + 1
                nums[idx] = n
                idx += 1
        
        return idx