# https://leetcode.com/problems/two-sum/description/
#
# algorithms
# Easy (39.29%)
# Total Accepted:    1.1M
# Total Submissions: 2.8M
# beats 52.43% of python submissions


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        nums_target = {}

        for idx, n in enumerate(nums):
            pair_idx = nums_target.get(target - n, -1)
            if pair_idx != -1:
                return [pair_idx, idx]
            else:
                nums_target[n] = idx
