# https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
#
# algorithms
# Easy (33.62%)
# Total Accepted:    437.1K
# Total Submissions: 1.3M
# beats 33.88% of python submissions

from collections import deque


class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = deque()

        for ch in s:
            if ch == '(' or ch == '[' or ch == '{' or len(stack) == 0:
                stack.append(ch)
            elif ch == ')':
                if stack[-1] == '(':
                    stack.pop()
                else:
                    stack.append(ch)
            elif ch == ']':
                if stack[-1] == '[':
                    stack.pop()
                else:
                    stack.append(ch)
            elif ch == '}':
                if stack[-1] == '{':
                    stack.pop()
                else:
                    stack.append(ch)

        return len(stack) == 0
