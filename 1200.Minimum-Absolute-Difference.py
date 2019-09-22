# https://leetcode.com/problems/minimum-absolute-difference/
# Easy (64.82%)
# Total Accepted:    4,099
# Total Submissions: 6,324
# beats 100.0 % of python submissions


class Solution(object):
    def minimumAbsDifference(self, arr):
        """
        :type arr: List[int]
        :rtype: List[List[int]]
        """
        length = len(arr)
        if length < 2:
            return []

        arr.sort()
        res = []
        min_diff = float('inf')

        for i in xrange(1, length):
            diff = arr[i] - arr[i - 1]
            if diff < min_diff:
                res = [[arr[i - 1], arr[i]]]
                min_diff = diff
            elif diff == min_diff:
                res.append([arr[i - 1], arr[i]])

        return res
