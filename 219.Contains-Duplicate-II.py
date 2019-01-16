# https://leetcode.com/problems/contains-duplicate-ii/
#
# algorithms
# Easy (34.35%)
# Total Accepted:    176,832
# Total Submissions: 514,775
# beats 79.72% of python submissions

class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        hash_map = {}
        
        for idx, n in enumerate(nums):
            if n in hash_map:
                if idx - hash_map[n] <= k:
                    return True
            hash_map[n] = idx
            
        return False
        