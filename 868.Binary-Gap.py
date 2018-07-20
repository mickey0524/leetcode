# https://leetcode.com/problems/binary-gap/description/
#
# algorithms
# Easy (62.0%)
# Total Accepted:    5.1k
# Total Submissions: 8.2k
# beats 77.89% of python submissions

# Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
# If there aren't two consecutive 1's, return 0.

# example
# Input: 22
# Output: 2
# Explanation:
# 22 in binary is 0b10110.
# In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
# The first consecutive pair of 1's have distance 2.
# The second consecutive pair of 1's have distance 1.
# The answer is the largest of these two distances, which is 2.


class Solution(object):
    def binaryGap(self, N):
        """
        :type N: int
        :rtype: int
        """
        binary = bin(N).replace('0b', '')
        cnt_one_idx = None
        res = 0

        for idx, bit in enumerate(binary):
            if bit == '1':
                if cnt_one_idx is not None:
                    res = max(res, idx - cnt_one_idx)
                cnt_one_idx = idx

        return res
