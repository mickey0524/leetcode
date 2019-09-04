# https://leetcode.com/problems/reverse-integer/
#
# algorithms
# Easy (25.47%)
# Total Accepted:    788,481
# Total Submissions: 3,095,159
# beats 100.0% of python submissions


class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0:
            return 0

        positive = True
        x_str = str(x)
        if x_str[0] == '-':
            positive = False
            x_str = x_str[1:]

        BOUND = 2 ** 31 - 1 if positive else 2 ** 31

        arr = list(x_str)
        i, j = 0, len(arr) - 1
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1

        res = 0
        for i in xrange(len(arr)):
            bit = int(arr[i])
            if (BOUND - bit) / 10 < res:
                return 0

            res = res * 10 + bit

        if positive:
            return res

        return -res
