# https://leetcode.com/problems/powx-n/
#
# algorithms
# Medium (28.52%)
# Total Accepted:    355,874
# Total Submissions: 1,247,822


class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1

        negative = False
        if n < 0:
            n = -n
            negative = True

        ans = self.myPow(x, n / 2)
        if n & 1 == 1:
            ans = ans * ans * x
        else:
            ans = ans * ans

        if negative:
            return 1. / ans

        return ans
