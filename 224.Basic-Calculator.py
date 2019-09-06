# https://leetcode.com/problems/basic-calculator/
#
# algorithms
# Hard (33.82%)
# Total Accepted:    120,177
# Total Submissions: 355,380
# beats 65.45% of python submissions


from collections import deque


class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()
        length = len(s)

        stack = deque()
        cur_num, cur_sample = 0, 1

        idx = 0

        while idx < length:
            ch = s[idx]
            if ch == ' ':
                idx += 1
                continue

            if ch.isdigit():
                j = idx + 1
                while j < length and s[j].isdigit():
                    j += 1

                num = int(s[idx:j])
                cur_num += (cur_sample * num)
                idx = j
                continue

            if ch == '+':
                cur_sample = 1

            elif ch == '-':
                cur_sample = -1

            elif ch == '(':
                stack.append((cur_num, cur_sample))
                cur_num, cur_sample = 0, 1

            else:
                pre_num, pre_sample = stack.pop()
                cur_sample = 1
                cur_num = pre_num + pre_sample * cur_num

            idx += 1

        return cur_num
