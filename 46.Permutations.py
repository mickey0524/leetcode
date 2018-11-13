# https://leetcode.com/problems/permutations/description/
#
# algorithms
# Medium (51.22%)
# Total Accepted:    298.4K
# Total Submissions: 583.7K
# beats 100.0% of python submissions

import itertools


class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        perm = list(itertools.permutations(nums))

        return perm
