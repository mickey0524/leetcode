# https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
#
# algorithms
# Medium (38.39%)
# Total Accepted:    56,774
# Total Submissions: 147,893


from collections import deque


class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        if preorder == '#':
            return True

        arr = preorder.split(',')
        length = len(arr)
        if arr[0] == '#':
            return False

        stack = deque([0])
        is_right = False

        for s in arr[1:]:
            stack_len = len(stack)
            if s == '#':
                if stack_len == 0:
                    return False
                if stack[-1] == 0:
                    stack[-1] = 1
                else:
                    stack.pop()
                    while len(stack) > 0 and stack[-1] == 1:
                        stack.pop()
                    if len(stack) > 0:
                        stack[-1] = 1

            else:
                if stack_len == 0:
                    return False
                stack.append(0)

        return True if len(stack) == 0 else False
