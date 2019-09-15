# https://leetcode.com/problems/day-of-the-week/
# Easy (54.07%)
# Total Accepted:    3,078
# Total Submissions: 5,692
# beats 100.0 % of python submissions


from collections import deque


class Solution(object):
    def reverseParentheses(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = deque()
        pre = 0
        res = []
        idx = 0
        length = len(s)

        while idx < length:
            if s[idx] == '(':
                if not stack:
                    res.append(s[pre:idx])
                else:
                    stack[-1] = stack[-1] + s[pre:idx]

                i = idx + 1
                while s[i] != '(' and s[i] != ')':
                    i += 1

                if s[i] == '(':
                    stack.append(s[idx + 1:i])
                    idx = i
                else:
                    tmp = s[idx + 1:i][::-1]
                    if not stack:
                        res.append(tmp)
                    else:
                        stack[-1] = stack[-1] + tmp

                    idx = i + 1
                pre = idx

            elif s[idx] == ')':
                prefix = stack.pop()
                tmp = prefix + s[pre:idx]
                if not stack:
                    res.append(tmp[::-1])
                else:
                    stack[-1] = stack[-1] + tmp[::-1]

                idx += 1
                pre = idx

            else:
                idx += 1

        res.append(s[pre:])

        return ''.join(res)
