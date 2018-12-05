# https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
#
# algorithms
# Medium (32.42%)
# Total Accepted:    146,296
# Total Submissions: 451,297

from bisect import bisect


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        length = len(nums)
        if length == 0:
            return False

        if length == 1:
            return True if nums[0] == target else False

        head, tail, middle = 0, length - 1, None

        while head <= tail:
            middle = head + (tail - head) / 2
            if nums[middle] == target:
                return True
            if nums[middle] < nums[tail]:
                if target > nums[middle] and target <= nums[tail]:
                    head = middle + 1
                else:
                    tail = middle - 1
            elif nums[middle] > nums[tail]:
                if target < nums[middle] and target >= nums[head]:
                    tail = middle - 1
                else:
                    head = middle + 1
            else:
                tail -= 1

        return False
