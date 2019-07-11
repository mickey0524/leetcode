# https://leetcode.com/problems/next-permutation/
#
# algorithms
# Medium (30.69%)
# Total Accepted:    248,671
# Total Submissions: 810,285


class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        if length < 2:
            return

        if length == 2:
            nums[0], nums[1] = nums[1], nums[0]
            return

        if nums[-1] > nums[-2]:
            nums[-1], nums[-2] = nums[-2], nums[-1]
            return

        i = length - 1
        while i > 0 and nums[i - 1] >= nums[i]:
            i -= 1

        if i == 0:
            nums.sort()
            return

        swap_idx, delta = i, float('inf')
        for j in xrange(i, length):
            if nums[j] > nums[i - 1] and nums[j] - nums[i - 1] < delta:
                swap_idx = j
        nums[swap_idx], nums[i - 1] = nums[i - 1], nums[swap_idx]

        tmp = nums[i:]
        tmp.sort()
        for j in xrange(i, length):
            nums[j] = tmp[j - i]

        return
