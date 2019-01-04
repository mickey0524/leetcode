# https://leetcode.com/problems/maximum-width-ramp/
# Medium (35.99%)
# Total Accepted:    4,298
# Total Submissions: 11,942

from bisect import bisect
from collections import deque

class Solution(object):
    def maxWidthRamp(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        length = len(A)
        if A[0] <= A[-1]:
            return length - 1

        stack = deque()
        stack.appendleft((A[0], 0))
        res = 0

        for idx, n in enumerate(A[1:]):
            if n < stack[0][0]:
                stack.appendleft((n, idx + 1))
            else:
                j = stack[bisect(stack, (n, idx + 1)) - 1][1]
                res = max(res, idx + 1 - j)

        return res

# AC 之后发现别人还有更简单的做法，记录一下，只在 stack 中放置 idx，因为要求最大的 gap，直接在第一个 A[s[-1]] <= A[j]
# 的时候 pop 就行，非常快

def maxWidthRamp(self, A):
    s = []
    res = 0
    for i, a in enumerate(A):
        if not s or A[s[-1]] > a:
            s.append(i)
    for j in range(len(A))[::-1]:
        while s and A[s[-1]] <= A[j]:
            res = max(res, j - s.pop())
    return res