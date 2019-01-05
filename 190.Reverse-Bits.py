# https://leetcode.com/problems/reverse-bits/
#
# algorithms
# Easy (29.45%)
# Total Accepted:    162,523
# Total Submissions: 551,908


class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        bit = bin(n)[2:][::-1]
        
        if len(bit) < 32:
            bit += '0' * (32 - len(bit))
        
        return int(bit, 2)
        