# https://leetcode.com/problems/score-of-parentheses/description/
#
# algorithms
# Medium (55.2%)
# Total Accepted:    4.7K
# Total Submissions: 8.5K
# beats 100.0% of python submissions


from collections import deque


class Solution(object):
    def scoreOfParentheses(self, S):
        """
        :type S: str
        :rtype: int
        """
        stack = deque()
        stack.append(['^', 0])

        for item in S:
            if item == '(':
                stack.append(['(', 0])
            else:
                char, cnt_sum = stack.pop()
                if cnt_sum == 0:
                    cnt_sum = 1
                if stack[-1][0] == '^':
                    stack[-1][1] += cnt_sum
                else:
                    stack[-1][1] += cnt_sum * 2

        return stack[0][1]
