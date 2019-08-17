# https://leetcode.com/problems/hamming-distance/
#
# algorithms
# Easy (70.58%)
# Total Accepted:    253,549
# Total Submissions: 359,219


class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        ans = 0

        for _ in xrange(32):
            x_bit, y_bit = x & 1, y & 1
            if x_bit != y_bit:
                ans += 1

            x >>= 1
            y >>= 1

        return ans


class Solution1(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        xor = x ^ y
        res = 0

        while xor:
            res += 1
            xor &= (xor - 1)

        return res
