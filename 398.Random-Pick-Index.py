# https://leetcode.com/problems/random-pick-index/description/
#
# algorithms
# Medium (47.24%)
# Total Accepted:    45.3k
# Total Submissions: 95.9k
# beats 90.16% of python submissions
# 水塘抽样


from random import randint


class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        count = 0
        index = -1
        for idx, n in enumerate(self.nums):
            if n == target:
                if randint(0, count) == 0:
                    index = idx
                count += 1

        return index


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)
