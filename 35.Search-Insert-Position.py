# https://leetcode.com/problems/search-insert-position/description/
#
# algorithms
# Easy (41.9%)
# Total Accepted:    296.7k
# Total Submissions: 741.4k
# beats 40.0% of python submissions


class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        length = len(nums)
        head, tail, middle = 0, length - 1, None

        while head < tail:
            middle = head + (tail - head) / 2
            if nums[middle] == target:
                return middle
            if nums[middle] < target:
                head = middle + 1
            else:
                tail = middle

        return tail if nums[tail] >= target else tail + 1
