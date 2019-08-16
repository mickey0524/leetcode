# https://leetcode.com/problems/subarray-sum-equals-k/
#
# algorithms
# Medium (42.67%)
# Total Accepted:    125,590
# Total Submissions: 294,336


from collections import defaultdict

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        length = len(nums)
        for i in xrange(1, length):
            nums[i] += nums[i - 1]
        
        hash_map = defaultdict(int)
        hash_map[0] = 1
        res = 0
        
        for n in nums:
            target_k = n - k
            res += hash_map[target_k]
            hash_map[n] += 1
            
        return res
    