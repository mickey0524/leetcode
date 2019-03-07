# https://leetcode.com/problems/total-hamming-distance/
#
# algorithms
# Medium (48.59%)
# Total Accepted:    43,815
# Total Submissions: 90,167
# beats 65.29% of python submissions


class Solution(object):
    def totalHammingDistance(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        bit = 1

        for i in xrange(32):
            one, zero = 0, 0
            for n in nums:
                if n & bit:
                    one += 1
                else:
                    zero += 1

            res += one * zero
            bit <<= 1

        return res
