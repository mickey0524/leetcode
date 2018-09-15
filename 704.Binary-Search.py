# https://leetcode.com/problems/binary-search/description/
#
# algorithms
# Easy (34.16%)
# Total Accepted:    9.6K
# Total Submissions: 28.1K
# beats 99.00% of python submissions


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        head, tail, middle = 0, len(nums) - 1, None

        while head <= tail:
            middle = head + (tail - head) / 2
            if nums[middle] == target:
                return middle
            elif nums[middle] > target:
                tail = middle - 1
            else:
                head = middle + 1

        return -1
