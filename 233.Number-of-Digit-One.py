# https://leetcode.com/problems/number-of-digit-one/
#
# algorithms
# Hard (30.02%)
# Total Accepted:    39,845
# Total Submissions: 132,733


class Solution(object):

    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 0:
            return 0

        if n < 10:
            return 1

        str_n = str(n)
        length = len(str_n)

        first_bit_sum = 10**(length -
                             1) if str_n[0] > '1' else int(str_n[1:]) + 1

        other_bit_sum = 10**(length - 2) * int(str_n[0]) * (length - 1)

        return first_bit_sum + other_bit_sum + self.countDigitOne(int(str_n[1:]))
