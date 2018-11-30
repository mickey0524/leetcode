# https://leetcode.com/problems/validate-stack-sequences/
#
# algorithms
# Medium (55.6%)
# Total Accepted:    3,978
# Total Submissions: 7,159
# beats 88.40% of python submissions

from collections import deque


class Solution(object):
    def validateStackSequences(self, pushed, popped):
        """
        :type pushed: List[int]
        :type popped: List[int]
        :rtype: bool
        """
        length = len(pushed)

        if length <= 1:
            return True

        push_idx, pop_idx = 0, 0
        stack_map = {}
        stack = deque()

        while pop_idx < length:
            if popped[pop_idx] in stack_map:
                if stack[-1] != popped[pop_idx]:
                    return False
                else:
                    stack.pop()

            else:
                while push_idx < length and pushed[push_idx] != popped[pop_idx]:
                    stack.append(pushed[push_idx])
                    stack_map[pushed[push_idx]] = True
                    push_idx += 1
                if push_idx == length:
                    return False
                push_idx += 1

            pop_idx += 1

        return True
