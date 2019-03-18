# https://leetcode.com/problems/complement-of-base-10-integer/
# Easy (57.42%)
# Total Accepted:    4,554
# Total Submissions: 7,931
# beats 100.0% of python submissions


class Solution(object):
    def bitwiseComplement(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N == 0:
            return 1

        binary = bin(N)[2:]
        tmp = ['1' if ch == '0' else '0' for ch in binary]

        return int(''.join(tmp), 2)
