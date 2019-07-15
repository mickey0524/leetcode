# https://leetcode.com/problems/find-the-duplicate-number/
#
# algorithms
# Medium (50.19%)
# Total Accepted:    200,592
# Total Submissions: 399,676


class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        slow, fast = 0, 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break

        finder = 0

        while slow != finder:
            slow = nums[slow]
            finder = nums[finder]

        return slow
