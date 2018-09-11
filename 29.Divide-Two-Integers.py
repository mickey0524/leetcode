# https://leetcode.com/problems/divide-two-integers/description/
#
# algorithms
# Medium (15.74%)
# Total Accepted:    149.6k
# Total Submissions: 950.6k
# beats 38.54% of python submissions


class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        symbol = -1
        if (dividend > 0 and divisor > 0) or \
                (dividend < 0 and divisor < 0):
            symbol = 1

        dividend = int(math.fabs(dividend))
        divisor = int(math.fabs(divisor))

        if divisor > dividend:
            return 0

        res, temp, count = 0, None, None

        while divisor <= dividend:
            temp = divisor
            count = 1
            while temp <= dividend:
                count <<= 1
                temp <<= 1
            temp >>= 1
            count >>= 1
            res += count
            dividend -= temp

        if res > 2 ** 31 - 1 and symbol == 1:
            res = 2 ** 31 - 1

        return symbol * res
