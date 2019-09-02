# https://leetcode.com/problems/remove-invalid-parentheses/
#
# algorithms
# Hard (40.13%)
# Total Accepted:    141,220
# Total Submissions: 351,940


class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        length = len(s)
        left_rem, right_rem = 0, 0

        for ch in s:
            if ch == '(':
                left_rem += 1
            elif ch == ')':
                if left_rem > 0:
                    left_rem -= 1
                else:
                    right_rem += 1

        hash_map = {}

        def recursive(idx, left_brackets, right_brackets, left_rem, right_rem, path):
            if idx == length:
                if left_rem == 0 and right_rem == 0:
                    hash_map[''.join(path)] = True
                return

            if s[idx] == '(' and left_rem > 0:
                recursive(idx + 1, left_brackets, right_brackets,
                          left_rem - 1, right_rem, path)

            if s[idx] == ')' and right_rem > 0:
                recursive(idx + 1, left_brackets, right_brackets,
                          left_rem, right_rem - 1, path)

            path.append(s[idx])

            if s[idx] == '(':
                recursive(idx + 1, left_brackets + 1,
                          right_brackets, left_rem, right_rem, path)

            elif s[idx] == ')':
                if right_brackets < left_brackets:
                    recursive(idx + 1, left_brackets,
                              right_brackets + 1, left_rem, right_rem, path)

            else:
                recursive(idx + 1, left_brackets, right_brackets,
                          left_rem, right_rem, path)

            path.pop()

        recursive(0, 0, 0, left_rem, right_rem, [])

        return hash_map.keys()
