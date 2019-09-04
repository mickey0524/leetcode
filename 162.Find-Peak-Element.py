# https://leetcode.com/problems/intersection-of-two-linked-lists/
#
# algorithms
# Medium (41.75%)
# Total Accepted:    262,503
# Total Submissions: 628,724
# beats 100.0% of python submissions


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        l, r, m = 0, length - 1, -1

        while l <= r:
            m = l + (r - l) / 2
            pre = float('-inf') if m == 0 else nums[m - 1]
            next = float('-inf') if m == length - 1 else nums[m + 1]

            if nums[m] > pre and nums[m] > next:
                return m

            elif next > nums[m]:
                l = m + 1

            else:
                r = m - 1

        return -1
