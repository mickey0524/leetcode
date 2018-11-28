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
        s = s.replace(' ', '')
        stack = deque()
        i = 0
        length = len(s)

        while i < length:
            if ord(s[i]) >= 48 and ord(s[i]) <= 57:
                begin_idx = i
                i += 1
                while i < length and ord(s[i]) >= 48 and ord(s[i]) <= 57:
                    i += 1
                num = int(s[begin_idx:i])
                if len(stack) == 0 or stack[0] == '+' or stack[0] == '-':
                    stack.appendleft(num)
                else:
                    if stack[0] == '*':
                        op = stack.popleft()
                        another_num = stack.popleft()
                        stack.appendleft(num * another_num)
                    if stack[0] == '/':
                        op = stack.popleft()
                        another_num = stack.popleft()
                        stack.appendleft(another_num / num)
            else:
                stack.appendleft(s[i])
                i += 1

        while len(stack) != 1:
            num1 = stack.pop()
            op = stack.pop()
            num2 = stack.pop()
            res = num1 + num2 if op == '+' else num1 - num2
            stack.append(res)

        return stack[0]
