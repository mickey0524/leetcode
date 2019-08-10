# https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
# Medium (65.00%)
# Total Accepted:    3,540
# Total Submissions: 5,446

from collections import deque


class Solution(object):
    def maxDepthAfterSplit(self, seq):
        """
        :type seq: str
        :rtype: List[int]
        """
        length = len(seq)
        res = [0] * length
        if length == 2:
            return res
        flag = 0

        stack = deque()
        for i in xrange(length):
            if seq[i] == '(':
                if stack:
                    flag = 1 - stack[-1][0]
                stack.append((flag, i))
            else:
                f, idx = stack.pop()
                res[idx] = f
                res[i] = f

        return res
