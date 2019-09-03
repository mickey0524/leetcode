# https://leetcode.com/problems/valid-number/
#
# algorithms
# Hard (14.28%)
# Total Accepted:    133,707
# Total Submissions: 936,394


class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.strip()
        length = len(s)
        if length == 0:
            return False

        if s[0] == '+' or s[0] == '-':
            s = s[1:]
            length -= 1

        if s == '.':
            return False

        if length == 0 or (not s[0].isdigit() and s[0] != '.'):
            return False

        DIGIT, POINT, EXP = 1, 2, 3
        state = DIGIT if s[0].isdigit() else POINT
        idx = 0

        if state == DIGIT:
            while idx < length:
                if s[idx].isdigit():
                    idx += 1
                else:
                    if s[idx] == '.':
                        state = POINT
                        break
                    elif s[idx] == 'e':
                        state = EXP
                        break
                    else:
                        return False

            if idx == length:
                return True

        if state == POINT:
            idx += 1
            if idx == length:
                return True
            if not s[idx].isdigit() and s[idx] != 'e':
                return False

            while idx < length:
                if s[idx].isdigit():
                    idx += 1
                elif s[idx] == 'e':
                    if idx == 1:
                        return False
                    state = EXP
                    break
                else:
                    return False

            if idx == length:
                return True

        if state == EXP:
            idx += 1
            if idx == length:
                return False
            if s[idx] == '+' or s[idx] == '-':
                idx += 1
            if idx == length or not s[idx].isdigit():
                return False

            while idx < length:
                if not s[idx].isdigit():
                    return False

                idx += 1

            return True

        return False
