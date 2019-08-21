# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
#
# algorithms
# Medium (34.03%)
# Total Accepted:    334,515
# Total Submissions: 982,931


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(nums)
        if length == 0:
            return [-1, -1]
        if target < nums[0] or target > nums[-1]:
            return [-1, -1]

        l, r, m = 0, length - 1, -1
        res = [-1, -1]

        while l <= r:
            m = l + (r - l) / 2

            if nums[m] > target:
                r = m - 1
            elif nums[m] < target:
                l = m + 1
            else:
                if m == 0 or nums[m - 1] != target:
                    res[0] = m
                    break
                else:
                    r = m - 1
        if res[0] == -1:
            return [-1, -1]

        l, r, m = 0, length - 1, -1
        while l <= r:
            m = l + (r - l) / 2

            if nums[m] > target:
                r = m - 1
            elif nums[m] < target:
                l = m + 1
            else:
                if m == length - 1 or nums[m + 1] != target:
                    res[1] = m
                    break
                else:
                    l = m + 1

        return res
