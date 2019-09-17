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


class Solution1(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        length = len(nums)
        if length < 2:
            return [nums]

        nums.sort()
        res = []

        for i in xrange(length):
            if i != 0 and nums[i] == nums[i - 1]:
                continue

            nums[0], nums[i] = nums[i], nums[0]

            recursive_res = self.permuteUnique(nums[1:])
            for arr in recursive_res:
                res.append([nums[0]] + arr)

            nums[0], nums[i] = nums[i], nums[0]

        return res
        
