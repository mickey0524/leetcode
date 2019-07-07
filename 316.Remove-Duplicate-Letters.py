# https://leetcode.com/problems/remove-duplicate-letters/
#
# algorithms
# Hard (32.87%)
# Total Accepted:    58,863
# Total Submissions: 179,085
# beats 100.0% of python submissions

from collections import deque


class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s)
        last_letter_idx = [-1] * 26
        is_use = [False] * 26

        for idx, ch in enumerate(s):
            last_letter_idx[ord(ch) - 97] = idx

        stack = deque()

        for idx, ch in enumerate(s):
            ch_idx = ord(ch) - 97

            if not is_use[ch_idx]:
                while stack and stack[-1] > ch and last_letter_idx[ord(stack[-1]) - 97] > idx:
                    is_use[ord(stack[-1]) - 97] = False
                    stack.pop()

                stack.append(ch)
                is_use[ch_idx] = True

        return ''.join(stack)
