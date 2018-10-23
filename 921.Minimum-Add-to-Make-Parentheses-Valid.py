# https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
#
# algorithms
# Medium (71.6%)
# Total Accepted:    5.8K
# Total Submissions: 8.1K
# beats 35.47% of python submissions

from collections import deque


class Solution(object):
    def minAddToMakeValid(self, S):
        """
        :type S: str
        :rtype: int
        """
        stack = deque()

        for ch in S:
            if len(stack) == 0 or ch == '(':
                stack.append(ch)
            else:
                if stack[-1] == '(':
                    stack.pop()
                else:
                    stack.append(ch)

        return len(stack)
