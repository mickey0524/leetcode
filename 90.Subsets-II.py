# https://leetcode.com/problems/subsets-ii/description/
#
# algorithms
# Medium (40.24%)
# Total Accepted:    173.2K
# Total Submissions: 430.4K
# beats 100.0% of python submissions


class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        length = len(nums)

        res = set()

        def resursive(idx, path):
            res.add(tuple(sorted(path)))
            if idx == length:
                return

            for i in xrange(idx, length):
                resursive(i + 1, path + [nums[i]])

        resursive(0, [])

        return [list(path) for path in res]
