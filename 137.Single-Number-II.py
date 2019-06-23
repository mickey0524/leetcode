# https://leetcode.com/problems/single-number-ii/
#
# algorithms
# Medium (46.15%)
# Total Accepted:    168,857
# Total Submissions: 365,899


class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        bits = [0] * 32

        for n in nums:
            for i in xrange(32):
                if 1 & n == 1:
                    bits[i] += 1
                n >>= 1

        for i in xrange(32):
            bits[i] = bits[i] % 3

        res = 0

        for i, b in enumerate(bits):
            res |= (b << i)

        if res >= 2 ** 31:
            res -= 2 ** 32

        return res
