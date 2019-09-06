# https://leetcode.com/problems/basic-calculator-ii/description/
#
# algorithms
# Medium (31.8%)
# Total Accepted:    86.8K
# Total Submissions: 272.9K


from collections import deque


class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = deque()

        s = s.strip()
        length = len(s)

        idx = 0

        while idx < length:
            if s[idx] == ' ':
                idx += 1
                continue

            if s[idx].isdigit():
                j = idx + 1
                while j < length and s[j].isdigit():
                    j += 1

                n = int(s[idx:j])
                if stack and (stack[-1] == '*' or stack[-1] == '/'):
                    op = stack.pop()
                    pre_num = stack.pop()
                    if op == '*':
                        n = n * pre_num
                    else:
                        n = pre_num / n

                stack.append(n)
                idx = j

            else:
                stack.append(s[idx])
                idx += 1

        pre_num = stack.popleft()

        while stack:
            op = stack.popleft()
            next_num = stack.popleft()
            if op == '+':
                pre_num += next_num
            else:
                pre_num -= next_num

        return pre_num
