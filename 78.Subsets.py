# https://leetcode.com/problems/subsets/description/
#
# algorithms
# Medium (47.05%)
# Total Accepted:    293.4K
# Total Submissions: 602.3K


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        length = len(nums)

        res = [[]]

        def resursive(idx, path):
            res[0].append(path)
            if idx == length:
                return

            for i in xrange(idx, length):
                resursive(i + 1, path + [nums[i]])

        resursive(0, [])

        return res[0]
