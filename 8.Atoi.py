# https://leetcode.com/problems/string-to-integer-atoi/
#
# algorithms
# Medium (16.6%)
# Total Accepted:    33,199
# Total Submissions: 200,347


class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        INT_MAX = 2147483648
        str = str.strip()
        if len(str) == 0:
            return 0

        symbol = 1

        if str[0] == '-':
            symbol = -1
            str = str[1:]
        elif str[0] == '+':
            str = str[1:]

        res = 0
        i = 0
        length = len(str)

        while i < length:
            if not str[i].isdigit():
                return res
            j = i + 1
            while j < length and str[j].isdigit():
                j += 1
            tmp = int(str[i:j])
            if tmp >= INT_MAX:
                return INT_MAX - 1 if symbol == 1 else -INT_MAX
            res = tmp * symbol
            i = j

        return res
