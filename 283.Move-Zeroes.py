# https://leetcode.com/problems/move-zeroes/description/
#
# algorithms
# Easy (52.73%)
# Total Accepted:    371.9K
# Total Submissions: 705.3K
# beats 100.0% of python submissions


class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        if length <= 1:
            return

        idx = 0
        for n in nums:
            if n != 0:
                nums[idx] = n
                idx += 1

        for i in xrange(idx, length):
            nums[i] = 0

        return
