# https://leetcode.com/problems/longest-valid-parentheses/
#
# algorithms
# Hard (26.11%)
# Total Accepted:    208,575
# Total Submissions: 798,959


from collections import deque


class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        if length == 0:
            return 0

        stack = deque()
        dp = [0] * length

        for idx, ch in enumerate(s):
            if ch == '(' or not stack:
                stack.append((ch, idx))

            elif ch == ')' and stack[-1][0] == ')':
                stack.append((ch, idx))

            else:
                _, i = stack.pop()
                dp[idx] = 2 + dp[idx - 1]

                if i > 0:
                    dp[idx] += dp[i - 1]

        return max(dp)
