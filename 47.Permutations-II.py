# https://leetcode.com/problems/permutations-ii/
#
# algorithms
# Medium (38.25%)
# Total Accepted:    208,226
# Total Submissions: 544,441

from itertools import permutations

class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return [list(t) for t in set(permutations(nums))]
        