# https://leetcode.com/problems/largest-rectangle-in-histogram/
#
# algorithms
# Hard (32.09%)
# Total Accepted:    192,415
# Total Submissions: 599,651


from collections import deque


class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        length = len(heights)
        l_2_r = [0] * length
        r_2_l = [0] * length

        stack = deque()
        for idx, h in enumerate(heights):
            while stack and h < heights[stack[-1]]:
                l_2_r[stack.pop()] = idx - 1

            stack.append(idx)

        while stack:
            l_2_r[stack.pop()] = length - 1

        for idx in xrange(length - 1, -1, -1):
            while stack and heights[idx] < heights[stack[-1]]:
                r_2_l[stack.pop()] = idx + 1

            stack.append(idx)

        while stack:
            r_2_l[stack.pop()] = 0

        res = 0
        for i in xrange(length):
            res = max(res, heights[i] * (l_2_r[i] - r_2_l[i] + 1))

        return res
