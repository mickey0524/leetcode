# https://leetcode.com/problems/remove-element/description/
#
# algorithms
# Easy (41.9%)
# Total Accepted:    312.2k
# Total Submissions: 745.1k
# beats 100.00% of python submissions


class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        length = len(nums)
        head, tail = 0, length - 1

        while head <= tail:
            if nums[head] == val:
                while head <= tail and nums[tail] == val:
                    tail -= 1
                if head < tail:
                    nums[head], nums[tail] = nums[tail], nums[head]
                    tail -= 1
            head += 1

        return tail + 1
