# https://leetcode.com/problems/merge-intervals/
#
# algorithms
# Medium (35.57%)
# Total Accepted:    344,251
# Total Submissions: 967,859


class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        length = len(intervals)
        if length < 2:
            return intervals

        intervals.sort()

        res = []
        start, end = intervals[0]
        for i in xrange(1, length):
            if intervals[i][0] > end:
                res += [start, end],
                start, end = intervals[i]
            else:
                end = max(intervals[i][1], end)

        res += [start, end],

        return res
