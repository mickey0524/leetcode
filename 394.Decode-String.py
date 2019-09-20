# https://leetcode.com/problems/decode-string/
#
# algorithms
# Medium (45.84%)
# Total Accepted:    118,973
# Total Submissions: 259,545


from collections import deque


class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s)
        if length < 2:
            return s

        stack, i = deque(), 0

        while i < length:
            if s[i] == ']':
                last_s = stack[-1]
                string = ''

                while type(last_s) is not int:
                    string = last_s + string
                    stack.pop()
                    last_s = stack[-1]

                stack.pop()

                stack.append(last_s * string)
                i += 1

            elif s[i].isdigit():
                j = i + 1
                while s[j].isdigit():
                    j += 1

                stack.append(int(s[i:j]))
                i = j + 1

            elif s[i].isalpha():
                j = i + 1
                while j < length and s[j].isalpha():
                    j += 1

                stack.append(s[i:j])
                i = j

        res = []
        while stack:
            res.insert(0, stack.pop())

        return ''.join(res)


from collections import deque


class Solution1(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = deque()
        length = len(s)
        i = 0

        while i < length:
            if s[i].isalpha():
                j = i + 1
                while j < length and s[j].isalpha():
                    j += 1
                stack.append(s[i:j])
                i = j

            elif s[i].isdigit():
                j = i + 1
                while j < length and s[j].isdigit():
                    j += 1
                stack.append(int(s[i:j]))
                i = j + 1

            elif s[i] == ']':
                tmp = ''
                while stack and type(stack[-1]) is not int:
                    tmp = stack[-1] + tmp
                    stack.pop()

                n = stack.pop()
                tmp = n * tmp
                stack.append(tmp)

                i += 1

        return ''.join(stack)
